package net.ti.todo.service.usecase;

import lombok.RequiredArgsConstructor;
import net.ti.todo.domain.entity.User;
import net.ti.todo.domain.model.UserWithRole;
import net.ti.todo.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserUseCase {
  private final UserRepository userRepository;

  /**
   * emailを指定してユーザーを1件取得する
   *
   * @param email ユーザーのemail
   * @return Boolean emailの存在有無
   */
  public Integer countUserByEmail(String email) {
    return userRepository.countUserByEmail(email);
  }

  /**
   * emailを指定してユーザーを1件取得する
   *
   * @param email ユーザー名またはemail
   * @return 条件に合致するユーザー
   */
  public UserWithRole getUserByEmail(String email){
    return userRepository.getUserByEmail(email);
  }


  /**
   * uuidを指定してユーザーを1件取得する
   *
   * @param uuid UUID
   * @return User ユーザー情報
   */
  public User getUserByUuid(String uuid) {
    return userRepository.getUserByUuid(uuid);
  }

  /**
   * 姓か名に合致するユーザーのlistを取得する
   *
   * @param lastName  姓名_姓
   * @param firstName 姓名_名
   * @return 姓か名に合致するユーザーのList
   */
  public List<User> getUserByLastNameOrFirstName(String lastName, String firstName) {
    return userRepository.getUserByLastNameOrFirstName(lastName, firstName);
  }


}
