package net.ti.todo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
  private int id;
  private String uuid;
  private String title;
  private String description;
  private Boolean completed;
}
