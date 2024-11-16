package net.ti.todo.tmregis;

import lombok.RequiredArgsConstructor;
import net.ti.todo.service.domainservice.AuthService;
import net.ti.todo.tmregis.model.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterApiImpl implements RegisterApi {

  private final AuthService authService;

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> createRegister(RegisterUserDto registerUserDto) {
    authService.register(registerUserDto);
    return ResponseEntity.ok().build();
  }
}
