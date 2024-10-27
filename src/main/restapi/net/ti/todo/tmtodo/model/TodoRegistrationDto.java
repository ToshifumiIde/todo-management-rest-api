package net.ti.todo.tmtodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Todo登録用Dto
 */

@Schema(name = "TodoRegistrationDto", description = "Todo登録用Dto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TodoRegistrationDto {

  private String title;

  private String description;

  public TodoRegistrationDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TodoRegistrationDto(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public TodoRegistrationDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Todoのタイトル
   *
   * @return title
   */
  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "title", example = "タイトル", description = "Todoのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TodoRegistrationDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Todoの説明
   *
   * @return description
   */
  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "description", example = "説明", description = "Todoの説明", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoRegistrationDto todoRegistrationDto = (TodoRegistrationDto) o;
    return Objects.equals(this.title, todoRegistrationDto.title) &&
      Objects.equals(this.description, todoRegistrationDto.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoRegistrationDto {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

