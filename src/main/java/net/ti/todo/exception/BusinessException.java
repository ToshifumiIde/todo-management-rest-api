package net.ti.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {
  private HttpStatus httpStatus;
  private String title;
  private String description;
}
