package net.ti.todo.service.domainservice;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.Role;
import net.ti.todo.domain.entity.User;
import net.ti.todo.exception.BusinessException;
import net.ti.todo.exception.RegisterException;
import net.ti.todo.security.JwtTokenProvider;
import net.ti.todo.service.domainservice.common.UuidGenerator;
import net.ti.todo.service.usecase.RoleUseCase;
import net.ti.todo.service.usecase.UserRoleUseCase;
import net.ti.todo.service.usecase.UserUseCase;
import net.ti.todo.tmregis.model.JwtAuthResponse;
import net.ti.todo.tmregis.model.LoginDto;
import net.ti.todo.tmregis.model.RegisterUserDto;
import net.ti.todo.tmregis.model.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;
  private final PasswordEncoder passwordEncoder;
  private final RoleUseCase roleUseCase;
  private final UserRoleUseCase userRoleUseCase;
  private final UserUseCase userUseCase;

  /**
   * [機能ID] TMREGIS01<br>
   * ユーザー情報を用いてユーザー登録と権限登録を実施する
   *
   * @param dto ユーザー登録用Dto
   */
  @Override
  @Transactional
  public void register(RegisterUserDto dto) {

    // check user email is already exists in database
    if (Objects.nonNull(userUseCase.confirmExistenceByEmail(dto.getEmail()))) {
      throw new RegisterException(HttpStatus.BAD_REQUEST, "this email can't register in this system");
    }

    User registerUser = new User();
    registerUser.setUuid(UuidGenerator.generate());
    registerUser.setLastName(dto.getLastName());
    registerUser.setFirstName(dto.getFirstName());
    registerUser.setUserName(dto.getLastName() + dto.getFirstName());
    registerUser.setEmail(dto.getEmail());
    registerUser.setPassword(passwordEncoder.encode(dto.getPassword()));

    int registerUserResult = userUseCase.createUser(registerUser);
    if (!Objects.equals(registerUserResult, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "REGISTER FAILED", "user registered failed");
    }

    Role registerRole = roleUseCase.getRoleByRoleName(dto.getRole().toString());
    if (Objects.isNull(registerRole)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "INVALID ROLE", "role invalid");
    }

    int registerUserRoleResult = userRoleUseCase.createUserRole(registerUser.getId(), registerRole.getId());
    if (!Objects.equals(registerUserRoleResult, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "REGISTER FAILED", "role registered failed");
    }
  }

  /**
   * [機能ID] TMREGIS02<br>
   * ログイン処理を実行し、ログイン成功時はJWT Tokenを返却する
   *
   * @param dto ログインDto
   * @return JWTのアクセストークン
   */
  @Override
  @Transactional
  public ResponseEntity<JwtAuthResponse> login(LoginDto dto) {

    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserNameOrEmail(), dto.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtTokenProvider.generateToken(authentication);

    JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
    jwtAuthResponse.setAccessToken(token);

    Role role = roleUseCase.getRoleByEmail(dto.getUserNameOrEmail());
    if (UserRole.containsValue(role.getName())) {
      jwtAuthResponse.setRole(UserRole.getUserRoleByValue(role.getName()));
    }

    return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
  }
}
