package net.ti.todo.service.usecase;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.Todo;
import net.ti.todo.domain.repository.TodosRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TodosApiUseCase {

  private final TodosRepository todosRepository;


  /**
   * [機能ID] TMTODO06<br>
   * UUIDを指定してタスクを1件完了にする
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  public int completeTodoByUuid(String uuid) {
    return todosRepository.completeTodoByUuid(uuid);
  }


  /**
   * [機能ID] TMTODO02<br>
   * タスクを生成する
   *
   * @param entity
   * @return 成功時1、失敗時0
   */
  public int createTodo(Todo entity) {
    return todosRepository.createTodo(entity);

  }

  /**
   * [機能ID] TMTODO05<br>
   * UUIDを指定してタスクを1件削除する
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  public int deleteTodoByUuid(String uuid) {
    return todosRepository.deleteTodoByUuid(uuid);
  }


  /**
   * [機能ID] TMTODO03<br>
   * UUIDを指定してタスクを1件取得する
   *
   * @param uuid UUID
   * @return タスクのEntity
   */
  public Todo getTodoByUuid(String uuid) {
    return todosRepository.getTodoByUuid(uuid);
  }

  /**
   * [機能ID] TMTODO07<br>
   * UUIDを指定してタスクを1件未完了にする
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  public int incompleteTodoByUuid(String uuid){
    return  todosRepository.incompleteTodoByUuid(uuid);
  }


  /**
   * [機能ID] TMTODO01<br>
   * タスクを全件取得する
   *
   * @return タスクのList
   */
  public List<Todo> listTodos() {
    return todosRepository.listTodos();
  }


  /**
   * [機能ID] TMTODO04<br>
   * UUIDを指定してタスクを1件更新する
   *
   * @return 成功時1、失敗時0
   */
  public int updateTodoByUuid(String uuid, Todo entity) {
    return todosRepository.updateTodoByUuid(uuid, entity);
  }
}
