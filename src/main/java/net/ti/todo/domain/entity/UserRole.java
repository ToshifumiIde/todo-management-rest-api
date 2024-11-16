package net.ti.todo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole {
  private int userId;
  private int roleId;
}
