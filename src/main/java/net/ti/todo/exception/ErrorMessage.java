package net.ti.todo.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
  private int statusCode;
  private String title;
  private String description;

  public ErrorMessage(BusinessException e) {
    this.statusCode = e.getHttpStatus().value();
    this.title = e.getTitle();
    this.description = e.getDescription();
  }

  public ErrorMessage(ConstraintViolationException e) {
    final int INDEX = e.getMessage().indexOf(":");
    this.statusCode = HttpStatus.BAD_REQUEST.value();
    this.title = e.getMessage().substring(0, INDEX);
    this.description = e.getMessage().substring(INDEX + 2);
  }
}
