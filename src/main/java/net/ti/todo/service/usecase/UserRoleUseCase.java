package net.ti.todo.service.usecase;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.repository.UserRoleRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRoleUseCase {

  private final UserRoleRepository userRoleRepository;

  /**
   * ユーザーIDと権限IDを指定してユーザーの権限を登録する
   *
   * @param userId     ユーザーID
   * @param userRoleId 権限ID
   * @return 成功時1、失敗時0
   */
  public int createUserRole(int userId, int userRoleId) {
    return userRoleRepository.createUserRole(userId, userRoleId);
  }
}
