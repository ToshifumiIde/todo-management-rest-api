package net.ti.todo.domain.repository;

import net.ti.todo.domain.entity.User;
import net.ti.todo.domain.model.UserWithRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

  /**
   * emailを指定してユーザーを1件取得する
   *
   * @param email ユーザーのemail
   * @return Boolean emailの存在有無
   */
  Integer countUserByEmail(String email);

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
}
