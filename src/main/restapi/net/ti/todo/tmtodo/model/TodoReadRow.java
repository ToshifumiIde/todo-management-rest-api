package net.ti.todo.tmtodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * Todoリストの各要素を格納するDto
 */

@Schema(name = "TodoReadRow", description = "Todoリストの各要素を格納するDto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TodoReadRow {

  private String uuid;

  private String title;

  private String description;

  private Boolean completed;

  public TodoReadRow uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * UUID
   *
   * @return uuid
   */

  @Schema(name = "uuid", example = "a123456789012345678901234567890z", description = "UUID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uuid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public TodoReadRow title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Todoのタイトル
   *
   * @return title
   */

  @Schema(name = "title", example = "タイトル", description = "Todoのタイトル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TodoReadRow description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Todoの説明
   *
   * @return description
   */

  @Schema(name = "description", example = "説明", description = "Todoの説明", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TodoReadRow completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * Todoの完了状況
   *
   * @return completed
   */

  @Schema(name = "completed", example = "true", description = "Todoの完了状況", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completed")
  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoReadRow todoReadRow = (TodoReadRow) o;
    return Objects.equals(this.uuid, todoReadRow.uuid) &&
      Objects.equals(this.title, todoReadRow.title) &&
      Objects.equals(this.description, todoReadRow.description) &&
      Objects.equals(this.completed, todoReadRow.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, title, description, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoReadRow {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
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

