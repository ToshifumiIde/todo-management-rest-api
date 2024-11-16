package net.ti.todo.tmregis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * ユーザー登録用Dto
 */

@Schema(name = "RegisterUserDto", description = "ユーザー登録用Dto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RegisterUserDto {

  private String lastName;

  private String firstName;

  @Pattern(regexp = "^[a-zA-Z0-9!#$%&'*+\\/=?^_`{|}~-]+(\\.[a-zA-Z0-9!#$%&'*+\\/=?^_`{|}~-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
  private String email;

  private String password;

  private UserRole role;

  public RegisterUserDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RegisterUserDto(String lastName, String firstName, String email, String password, UserRole role) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public RegisterUserDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * ユーザー名_姓
   *
   * @return lastName
   */
  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "lastName", example = "田中", description = "ユーザー名_姓", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public RegisterUserDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * ユーザー名_名
   *
   * @return firstName
   */
  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "firstName", example = "太郎", description = "ユーザー名_名", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public RegisterUserDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   *
   * @return email
   */
  @NotNull
  @Size(min = 6, max = 255)
  @Schema(name = "email", example = "sample@gmail.com", description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RegisterUserDto password(String password) {
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

  public RegisterUserDto role(UserRole role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   *
   * @return role
   */
  @NotNull
  @Valid
  @Schema(name = "role", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterUserDto registerUserDto = (RegisterUserDto) o;
    return Objects.equals(this.lastName, registerUserDto.lastName) &&
      Objects.equals(this.firstName, registerUserDto.firstName) &&
      Objects.equals(this.email, registerUserDto.email) &&
      Objects.equals(this.password, registerUserDto.password) &&
      Objects.equals(this.role, registerUserDto.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName, email, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterUserDto {\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

