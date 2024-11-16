package net.ti.todo.domain.repository;

import net.ti.todo.domain.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {

  /**
   * 権限名を指定してRoleを取得する
   *
   * @param roleName 権限名
   * @return 権限のEntity
   */
  Role getRoleByName(String roleName);
}
