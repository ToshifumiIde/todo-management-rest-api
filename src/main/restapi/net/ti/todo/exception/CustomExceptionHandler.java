package net.ti.todo.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException e) {
    ErrorMessage message = new ErrorMessage(e);
    return ResponseEntity
      .status(message.getStatusCode())
      .body(message);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e){
    ErrorMessage message= new ErrorMessage(e);
    return ResponseEntity
      .status(message.getStatusCode())
      .body(message);
  }
}
