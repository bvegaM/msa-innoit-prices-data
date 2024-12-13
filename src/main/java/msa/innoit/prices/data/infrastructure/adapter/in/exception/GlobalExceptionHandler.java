package msa.innoit.prices.data.infrastructure.adapter.in.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import msa.innoit.prices.data.domain.exception.NotFoundException;
import msa.innoit.prices.data.infrastructure.utils.Util;
import msa.innoit.prices.data.server.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler({
      ConstraintViolationException.class
  })
  public ResponseEntity<Error> constraintViolationException(ConstraintViolationException exception){
    log.error("Constraint violation exception");

    var violations = exception.getConstraintViolations()
        .stream()
        .map(Util::generateErrorDetail)
        .toList();

    Error error = Util.createError("Violation Error",
        "The following conditions in the parameters were violated", violations,
        HttpStatus.BAD_REQUEST);

    return ResponseEntity.badRequest().body(error);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Void> methodArgumentNotValidExceptionHandler(
      NotFoundException exception) {
    log.error("Not found exception: {}", exception.getMessage());

    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Error> exceptionHandler(Exception exception) {
    log.error("Exception: {}", exception.getMessage());

    Error error = Util.createError("Bad Request Exception",
        exception.getMessage(), List.of(), HttpStatus.BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<Error> missingServletRequestParameterException(
      MissingServletRequestParameterException exception) {
    log.error("Missing parameter exception: {}", exception.getMessage());

    Error error = Util.createError("Missing Parameter Exception",
        exception.getMessage(), List.of(), HttpStatus.BAD_REQUEST);

    return ResponseEntity.badRequest().body(error);
  }

}
