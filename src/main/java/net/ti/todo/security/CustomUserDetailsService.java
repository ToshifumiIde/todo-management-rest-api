package net.ti.todo.security;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.model.UserWithRole;
import net.ti.todo.exception.BusinessException;
import net.ti.todo.service.usecase.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserUseCase userUseCase;


  @Override
  public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

    UserWithRole userWithRoles = userUseCase.getUserByEmail(userNameOrEmail);
    if (Objects.isNull(userWithRoles)) {
      throw new BusinessException(HttpStatus.NOT_FOUND, "RESOURCE NOT FOUND", "user not found");
    }

// 1ユーザーに対してRoleが複数ある場合は、streamAPIでSetに格納する
//    Set<GrantedAuthority> authorities = userWithRoles.getUser().getRole()
//      .stream()
//      .map(role -> new SimpleGrantedAuthority(role.getName()))
//      .collect(Collectors.toSet());

    Set<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority(userWithRoles.getRole().getName()));

    return new org.springframework.security.core.userdetails.User(
      userNameOrEmail,
      userWithRoles.getUser().getPassword(),
      authorities
    );
  }
}
