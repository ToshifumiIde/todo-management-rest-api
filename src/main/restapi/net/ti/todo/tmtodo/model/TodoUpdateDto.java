package net.ti.todo.tmtodo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Todo更新用Dto
 */

@Schema(name = "TodoUpdateDto", description = "Todo更新用Dto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TodoUpdateDto {

  private String title;

  private String description;

  private Boolean completed = false;

  public TodoUpdateDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Todoのタイトル
   * @return title
  */
  @Size(min = 1, max = 255) 
  @Schema(name = "title", example = "タイトル", description = "Todoのタイトル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TodoUpdateDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Todoの説明
   * @return description
  */
  @Size(min = 1, max = 255) 
  @Schema(name = "description", example = "説明", description = "Todoの説明", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TodoUpdateDto completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * Todoの完了状況
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
    TodoUpdateDto todoUpdateDto = (TodoUpdateDto) o;
    return Objects.equals(this.title, todoUpdateDto.title) &&
        Objects.equals(this.description, todoUpdateDto.description) &&
        Objects.equals(this.completed, todoUpdateDto.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoUpdateDto {\n");
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

