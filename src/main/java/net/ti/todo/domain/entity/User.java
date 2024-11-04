package net.ti.todo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private int id;
  private String uuid;
  private String lastName;
  private String firstName;
  private String email;
  private String password;
}
