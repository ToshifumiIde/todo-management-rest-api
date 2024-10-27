package net.ti.todo.domain.injector.tmtodo;

import lombok.AllArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.tmtodo.model.TodoUpdateDto;

@AllArgsConstructor
public class TodosUpdateInjector {
  private TodoUpdateDto todoUpdateDto;

  public Todo inject() {
    Todo entity = new Todo();
    entity.setTitle(todoUpdateDto.getTitle());
    entity.setDescription(todoUpdateDto.getDescription());
    return entity;
  }
}
