package com.company.profile.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON;
import static org.springframework.http.ResponseEntity.status;

import com.company.profile.dto.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Error> handleResourceNotFoundException(Exception ex) {

    Error problem = Error.of(String.valueOf(NOT_FOUND.value()), NOT_FOUND.name());

    return status(NOT_FOUND).contentType(APPLICATION_PROBLEM_JSON).body(problem);
  }

  @ExceptionHandler(InternalServiceErrorException.class)
  public ResponseEntity<Error> handleInternalServiceErrorException(Exception ex) {

    Error problem = Error.of(String.valueOf(INTERNAL_SERVER_ERROR.value()), INTERNAL_SERVER_ERROR.name());

    return status(INTERNAL_SERVER_ERROR).contentType(APPLICATION_PROBLEM_JSON).body(problem);
  }

}
