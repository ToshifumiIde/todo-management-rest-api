package net.ti.todo.tmtodo;

import lombok.RequiredArgsConstructor;
import net.ti.todo.service.domainservice.TodosApiService;
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

  private final TodosApiService todosApiService;

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> completeTodoByUuid(String uuid) {
    todosApiService.completeTodoByUuid(uuid);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> createTodo(TodoRegistrationDto todoRegistrationDto) {
    todosApiService.createTodo(todoRegistrationDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> deleteTodoByUuid(String uuid) {
    todosApiService.deleteTodoByUuid(uuid);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<TodoReadDto> getTodoByUuid(String uuid) {
    return new ResponseEntity<>(todosApiService.getTodoByUuid(uuid), HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> incompleteTodoByUuid(String uuid) {
    todosApiService.incompleteTodoByUuid(uuid);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<TodoReadDtoList> listTodos() {
    TodoReadDtoList list = todosApiService.listTodos();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEntity<Void> putTodoByUuid(String uuid, TodoUpdateDto todoUpdateDto) {
    todosApiService.updateTodoByUuid(uuid, todoUpdateDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
