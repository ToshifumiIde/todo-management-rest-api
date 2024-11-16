package net.ti.todo.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository {

  /**
   * ユーザーIDと権限IDを指定してユーザーの権限を登録する
   *
   * @param userId     ユーザーID
   * @param userRoleId 権限ID
   * @return 成功時1、失敗時0
   */
  int createUserRole(int userId, int userRoleId);
}
