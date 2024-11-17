package net.ti.todo.tmregis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * JwtAuthResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class JwtAuthResponse {

  private String accessToken;

  private String tokenType = "Bearer";

  private UserRole role;

  public JwtAuthResponse accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * JWTで生成されたアクセストークン<br> ヘッダー.ペイロード.署名<br> で構成される
   *
   * @return accessToken
   */

  @Schema(name = "accessToken", example = "xxxxxx.yyyyyy.zzzzzz", description = "JWTで生成されたアクセストークン<br> ヘッダー.ペイロード.署名<br> で構成される ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accessToken")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public JwtAuthResponse tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * トークン種別<br> デフォルトでBearerを返却する
   *
   * @return tokenType
   */

  @Schema(name = "tokenType", example = "Bearer", description = "トークン種別<br> デフォルトでBearerを返却する ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tokenType")
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public JwtAuthResponse role(UserRole role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   *
   * @return role
   */
  @Valid
  @Schema(name = "role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    JwtAuthResponse jwtAuthResponse = (JwtAuthResponse) o;
    return Objects.equals(this.accessToken, jwtAuthResponse.accessToken) &&
      Objects.equals(this.tokenType, jwtAuthResponse.tokenType) &&
      Objects.equals(this.role, jwtAuthResponse.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, tokenType, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JwtAuthResponse {\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
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

