package net.ti.todo.tmregis.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

import java.util.Arrays;
import java.util.Objects;

/**
 * Gets or Sets UserRole
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum UserRole {

  ADMIN("ROLE_ADMIN"),

  USER("ROLE_USER");

  private String value;

  UserRole(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }


  /**
   * 指定した値がEnumに存在するかチェックする
   *
   * @param value 入力値
   */
  public static boolean containsValue(String value) {
    return Arrays.stream(UserRole.values()).anyMatch(userRole -> userRole.toString().equals(value));
  }

  /**
   * 指定した値に合致するEnumを返却する<br>
   * 存在しない場合nullを返却する
   *
   * @param value 入力値
   * @return UserRoleのEnum
   */
  public static UserRole getUserRoleByValue(String value) {
    for (UserRole userRole : UserRole.values()) {
      if (Objects.equals(userRole.getValue(), value)) {
        return userRole;
      }
    }
    return null;
  }

  @JsonCreator
  public static UserRole fromValue(String value) {
    for (UserRole b : UserRole.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

