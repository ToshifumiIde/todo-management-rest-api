package net.ti.todo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * ResponseSingleMessage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ResponseSingleMessage {

  private Integer httpStatusCode;

  private String message;

  private String detail;

  public ResponseSingleMessage httpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * HTTPステータスコード
   *
   * @return httpStatusCode
   */

  @Schema(name = "httpStatusCode", example = "400", description = "HTTPステータスコード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("httpStatusCode")
  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public ResponseSingleMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * エラーメッセージ
   *
   * @return message
   */

  @Schema(name = "message", example = "message", description = "エラーメッセージ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ResponseSingleMessage detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * エラー詳細
   *
   * @return detail
   */

  @Schema(name = "detail", example = "detail", description = "エラー詳細", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseSingleMessage responseSingleMessage = (ResponseSingleMessage) o;
    return Objects.equals(this.httpStatusCode, responseSingleMessage.httpStatusCode) &&
      Objects.equals(this.message, responseSingleMessage.message) &&
      Objects.equals(this.detail, responseSingleMessage.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseSingleMessage {\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

