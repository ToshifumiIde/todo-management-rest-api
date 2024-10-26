package net.ti.todo.tmtodo;

import lombok.RequiredArgsConstructor;
import net.ti.todo.tmtodo.model.TodoReadDto;
import net.ti.todo.tmtodo.model.TodoReadDtoList;
import net.ti.todo.tmtodo.model.TodoRegistrationDto;
import net.ti.todo.tmtodo.model.TodoUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodosApiImpl implements TodosApi {
  @Override
  public ResponseEntity<Void> createTodo(TodoRegistrationDto todoRegistrationDto) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteTodoByUuid(String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<TodoReadDto> getTodoByUuid(String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<TodoReadDtoList> listTodos() {
    TodoReadDtoList list = new TodoReadDtoList();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> putTodoByUuid(String uuid, TodoUpdateDto todoUpdateDto) {
    return null;
  }
}
