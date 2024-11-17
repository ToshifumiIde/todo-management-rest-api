package net.ti.todo.service.domainservice;

import net.ti.todo.tmregis.model.JwtAuthResponse;
import net.ti.todo.tmregis.model.LoginDto;
import net.ti.todo.tmregis.model.RegisterUserDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  void register(RegisterUserDto dto);
  ResponseEntity<JwtAuthResponse> login(LoginDto dto);
}
