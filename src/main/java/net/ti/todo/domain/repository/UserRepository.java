package net.ti.todo.domain.repository;

import net.ti.todo.domain.entity.User;
import net.ti.todo.domain.model.UserWithRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

  /**
   * emailを指定してユーザーの存在有無を確認する
   *
   * @param email ユーザーのemail
   * @return 存在する場合は1、存在しない場合はNull
   */
  Integer confirmExistenceByEmail(String email);

  /**
   * uuidを指定してユーザーを1件取得する
   *
   * @param uuid UUID
   * @return User ユーザー情報
   */
  User getUserByUuid(String uuid);

  /**
   * 姓か名に合致するユーザーのlistを取得する
   *
   * @param lastName  姓名_姓
   * @param firstName 姓名_名
   * @return 姓か名に合致するユーザーのList
   */
  List<User> getUserByLastNameOrFirstName(String lastName, String firstName);


  /**
   * emailを指定してユーザーを1件取得する
   *
   * @param email email
   * @return 条件に合致するユーザー
   */
  UserWithRole getUserByEmail(String email);


  /**
   * User情報を元にUserを登録する
   *
   * @param user ユーザー情報
   * @return 登録成功時1、失敗時0
   */
  int createUser(User user);
}
