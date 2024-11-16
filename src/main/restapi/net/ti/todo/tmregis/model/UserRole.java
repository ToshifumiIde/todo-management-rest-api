package net.ti.todo.tmregis.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

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

