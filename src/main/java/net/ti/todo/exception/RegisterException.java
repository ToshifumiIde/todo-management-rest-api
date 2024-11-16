package net.ti.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RegisterException extends RuntimeException {
  private HttpStatus httpStatus;
  private String message;
}
