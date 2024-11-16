package net.ti.todo.service.domainservice;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.Role;
import net.ti.todo.domain.entity.User;
import net.ti.todo.exception.BusinessException;
import net.ti.todo.exception.RegisterException;
import net.ti.todo.service.domainservice.common.UuidGenerator;
import net.ti.todo.service.usecase.RoleUseCase;
import net.ti.todo.service.usecase.UserRoleUseCase;
import net.ti.todo.service.usecase.UserUseCase;
import net.ti.todo.tmregis.model.RegisterUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final RoleUseCase roleUseCase;
  private final UserRoleUseCase userRoleUseCase;
  private final UserUseCase userUseCase;
  private final PasswordEncoder passwordEncoder;

  /**
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
}
