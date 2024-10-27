package net.ti.todo.domain.injector.tmtodo;

import lombok.AllArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.tmtodo.model.TodoReadDto;

@AllArgsConstructor
public class TodosGetInjector {
  Todo entity;

  public TodoReadDto inject() {
    TodoReadDto dto = new TodoReadDto();
    dto.setUuid(entity.getUuid());
    dto.setTitle(entity.getTitle());
    dto.setDescription(entity.getDescription());
    dto.setCompleted(entity.getCompleted());
    return dto;
  }
}
