package io.brothersoo.acktion.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAll(Exception ex) {
    log.info(ex.getClass().getName());
    log.error("error", ex);
    return ResponseEntity.internalServerError().body(ex.getMessage());
  }
}
