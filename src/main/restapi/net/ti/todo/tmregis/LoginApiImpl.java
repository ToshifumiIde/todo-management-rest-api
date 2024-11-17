package net.ti.todo.tmregis;

import lombok.RequiredArgsConstructor;
import net.ti.todo.service.domainservice.AuthService;
import net.ti.todo.tmregis.model.JwtAuthResponse;
import net.ti.todo.tmregis.model.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginApiImpl implements LoginApi {

  private final AuthService authService;

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<JwtAuthResponse> login(LoginDto loginDto) {

    return authService.login(loginDto);
  }
}
