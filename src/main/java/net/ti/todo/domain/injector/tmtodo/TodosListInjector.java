package net.ti.todo.domain.injector.tmtodo;

import lombok.AllArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.tmtodo.model.TodoReadDtoList;
import net.ti.todo.tmtodo.model.TodoReadRow;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TodosListInjector {
  private List<Todo> todos;

  public TodoReadDtoList inject() {
    List<TodoReadRow> dataList = todos.stream().map(todo -> {
      TodoReadRow row = new TodoReadRow();
      row.setUuid(todo.getUuid());
      row.setTitle(todo.getTitle());
      row.setDescription(todo.getDescription());
      row.setCompleted(todo.getCompleted());
      return row;
    }).collect(Collectors.toList());

    TodoReadDtoList dto = new TodoReadDtoList();
    dto.setDataList(dataList);

    return dto;
  }
}
