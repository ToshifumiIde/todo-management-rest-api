package net.ti.todo.service.domainservice;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.domain.injector.tmtodo.TodosGetInjector;
import net.ti.todo.domain.injector.tmtodo.TodosListInjector;
import net.ti.todo.domain.injector.tmtodo.TodosRegistrationInjector;
import net.ti.todo.domain.injector.tmtodo.TodosUpdateInjector;
import net.ti.todo.exception.BusinessException;
import net.ti.todo.service.usecase.TodosApiUseCase;
import net.ti.todo.tmtodo.model.TodoReadDto;
import net.ti.todo.tmtodo.model.TodoReadDtoList;
import net.ti.todo.tmtodo.model.TodoRegistrationDto;
import net.ti.todo.tmtodo.model.TodoUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TodosApiServiceImpl implements TodosApiService {

  private final TodosApiUseCase todosApiUseCase;


  /**
   * [機能ID] TMTODO06<br>
   * UUIDを指定してタスクを1件完了にする
   *
   * @param uuid UUID
   */
  @Override
  public void completeTodoByUuid(String uuid) {
    Todo target = todosApiUseCase.getTodoByUuid(uuid);
    if (Objects.isNull(target)) {
      throw new BusinessException(HttpStatus.NOT_FOUND, "RESOURCE NOT FOUND", "failed to get resource " + uuid);
    }
    int result = todosApiUseCase.completeTodoByUuid(uuid);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "RESOURCE UPDATE FAILED", "failed to get resource");
    }
  }

  /**
   * [機能ID] TMTODO02<br>
   * タスクを登録する
   *
   * @param dto タスク登録用のDto
   */
  @Override
  public void createTodo(TodoRegistrationDto dto) {
    Todo entity = new TodosRegistrationInjector(dto).inject();
    int result = todosApiUseCase.createTodo(entity);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "CREATE FAILED", "failed to create resource");
    }
  }

  /**
   * [機能ID] TMTODO05<br>
   * UUIDを指定してタスクを1件削除する
   *
   * @param uuid UUID
   */
  @Override
  public void deleteTodoByUuid(String uuid) {
    int result = todosApiUseCase.deleteTodoByUuid(uuid);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "DELETE FAILED", "failed to delete resource");
    }
  }

  /**
   * [機能ID] TMTODO03<br>
   * UUIDを指定してタスクを1件取得する
   *
   * @param uuid UUID
   * @return タスクのDto
   */
  @Override
  public TodoReadDto getTodoByUuid(String uuid) {
    Todo entity = todosApiUseCase.getTodoByUuid(uuid);
    if (Objects.isNull(entity)) {
      throw new BusinessException(HttpStatus.NOT_FOUND, "RESOURCE NOT FOUND", "failed to get resource " + uuid);
    }
    return new TodosGetInjector(entity).inject();
  }

  /**
   * [機能ID] TMTODO07<br>
   * UUIDを指定してタスクを1件未完了にする
   *
   * @param uuid UUID
   */
  @Override
  public void incompleteTodoByUuid(String uuid) {
    Todo target = todosApiUseCase.getTodoByUuid(uuid);
    if (Objects.isNull(target)) {
      throw new BusinessException(HttpStatus.NOT_FOUND, "RESOURCE NOT FOUND", "failed to get resource " + uuid);
    }
    int result = todosApiUseCase.incompleteTodoByUuid(uuid);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST, "RESOURCE UPDATE FAILED", "failed to get resource");
    }
  }

  /**
   * [機能ID] TMTODO04<br>
   * UUIDを指定してタスクを1件更新する
   *
   * @param uuid          UUID
   * @param todoUpdateDto タスク更新用Dto
   */
  @Override
  public void updateTodoByUuid(String uuid, TodoUpdateDto todoUpdateDto) {
    Todo target = todosApiUseCase.getTodoByUuid(uuid);
    if (Objects.isNull(target)) {
      throw new BusinessException(HttpStatus.NOT_FOUND, "RESOURCE NOT FOUND", "failed to get resource " + uuid);
    }

    Todo entity = new TodosUpdateInjector(todoUpdateDto).inject();
    todosApiUseCase.updateTodoByUuid(uuid, entity);
  }

  /**
   * [機能ID] TMTODO01<br>
   * タスクを全件取得する
   */
  @Override
  public TodoReadDtoList listTodos() {
    List<Todo> todos = todosApiUseCase.listTodos();
    return new TodosListInjector(todos).inject();
  }

}
