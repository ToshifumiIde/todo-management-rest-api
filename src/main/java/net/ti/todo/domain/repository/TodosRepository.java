package net.ti.todo.domain.repository;

import net.ti.todo.domain.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository {
  /**
   * UUIDを指定してタスクを1件完了にする
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  int completeTodoByUuid(String uuid);

  /**
   * タスクを登録する
   *
   * @param entity タスクのEntity
   * @return 成功時1、失敗時0
   */
  int createTodo(Todo entity);

  /**
   * UUIDを指定してタスクを1件削除する
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  int deleteTodoByUuid(String uuid);

  /**
   * UUIDを指定してタスクを1件取得する
   *
   * @param uuid UUID
   * @return タスクのEntity
   */
  Todo getTodoByUuid(String uuid);

  /**
   * UUIDを指定してタスクを1件未完了にする
   *
   * @param uuid UUID
   * @return 成功時1、失敗時0
   */
  int incompleteTodoByUuid(String uuid);


  /**
   * タスク一覧を取得する
   *
   * @return タスクのList
   */
  List<Todo> listTodos();

  /**
   * UUIDを指定してタスクを1件更新する
   *
   * @param uuid   UUID
   * @param entity タスクのEntity
   * @return 成功時1、失敗時0
   */
  int updateTodoByUuid(String uuid, Todo entity);
}
