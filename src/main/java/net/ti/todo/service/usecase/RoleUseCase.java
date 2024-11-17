package net.ti.todo.service.usecase;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.Role;
import net.ti.todo.domain.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleUseCase {

  private final RoleRepository roleRepository;

  /**
   * 権限名を指定してRoleを取得する
   *
   * @param roleName 権限名
   * @return 権限のEntity
   */
  public Role getRoleByRoleName(String roleName) {
    return roleRepository.getRoleByName(roleName);
  }

  /**
   * メールアドレスを指定してRoleを取得する
   *
   * @param email メールアドレス
   * @return 権限のEntity
   */
  public Role getRoleByEmail(String email) {
    return roleRepository.getRoleByEmail(email);
  }
}
