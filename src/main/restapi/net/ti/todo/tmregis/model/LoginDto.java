package net.ti.todo.tmregis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * ログイン用Dto
 */

@Schema(name = "LoginDto", description = "ログイン用Dto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class LoginDto {

  private String userNameOrEmail;

  private String password;

  public LoginDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginDto(String userNameOrEmail, String password) {
    this.userNameOrEmail = userNameOrEmail;
    this.password = password;
  }

  public LoginDto userNameOrEmail(String userNameOrEmail) {
    this.userNameOrEmail = userNameOrEmail;
    return this;
  }

  /**
   * ユーザー名またはメールアドレス
   *
   * @return userNameOrEmail
   */
  @NotNull
  @Size(min = 6, max = 255)
  @Schema(name = "userNameOrEmail", example = "sample@gmail.com", description = "ユーザー名またはメールアドレス", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userNameOrEmail")
  public String getUserNameOrEmail() {
    return userNameOrEmail;
  }

  public void setUserNameOrEmail(String userNameOrEmail) {
    this.userNameOrEmail = userNameOrEmail;
  }

  public LoginDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * パスワード
   *
   * @return password
   */
  @NotNull
  @Size(min = 8, max = 255)
  @Schema(name = "password", example = "password", description = "パスワード", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginDto loginDto = (LoginDto) o;
    return Objects.equals(this.userNameOrEmail, loginDto.userNameOrEmail) &&
      Objects.equals(this.password, loginDto.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userNameOrEmail, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginDto {\n");
    sb.append("    userNameOrEmail: ").append(toIndentedString(userNameOrEmail)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

