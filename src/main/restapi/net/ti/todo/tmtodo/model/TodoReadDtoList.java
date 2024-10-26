package net.ti.todo.tmtodo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.ti.todo.tmtodo.model.TodoReadDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Todoのリストを格納するDto
 */

@Schema(name = "TodoReadDtoList", description = "Todoのリストを格納するDto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TodoReadDtoList {

  @Valid
  private List<@Valid TodoReadDto> dataList;

  public TodoReadDtoList dataList(List<@Valid TodoReadDto> dataList) {
    this.dataList = dataList;
    return this;
  }

  public TodoReadDtoList addDataListItem(TodoReadDto dataListItem) {
    if (this.dataList == null) {
      this.dataList = new ArrayList<>();
    }
    this.dataList.add(dataListItem);
    return this;
  }

  /**
   * Todoのリストを格納する配列
   * @return dataList
  */
  @Valid 
  @Schema(name = "dataList", description = "Todoのリストを格納する配列", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataList")
  public List<@Valid TodoReadDto> getDataList() {
    return dataList;
  }

  public void setDataList(List<@Valid TodoReadDto> dataList) {
    this.dataList = dataList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoReadDtoList todoReadDtoList = (TodoReadDtoList) o;
    return Objects.equals(this.dataList, todoReadDtoList.dataList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoReadDtoList {\n");
    sb.append("    dataList: ").append(toIndentedString(dataList)).append("\n");
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

