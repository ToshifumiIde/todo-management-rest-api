package net.ti.todo.service.domainservice;

import net.ti.todo.tmtodo.model.TodoReadDto;
import net.ti.todo.tmtodo.model.TodoReadDtoList;
import net.ti.todo.tmtodo.model.TodoRegistrationDto;
import net.ti.todo.tmtodo.model.TodoUpdateDto;

public interface TodosApiService {
  void completeTodoByUuid(String uuid);

  void createTodo(TodoRegistrationDto dto);

  void deleteTodoByUuid(String uuid);

  TodoReadDto getTodoByUuid(String uuid);

  void incompleteTodoByUuid(String uuid);

  void updateTodoByUuid(String uuid, TodoUpdateDto todoUpdateDto);

  TodoReadDtoList listTodos();
}
