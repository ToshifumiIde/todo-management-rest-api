package net.ti.todo.service.domainservice;

import net.ti.todo.tmregis.model.RegisterUserDto;

public interface AuthService {
  void register(RegisterUserDto dto);
}
