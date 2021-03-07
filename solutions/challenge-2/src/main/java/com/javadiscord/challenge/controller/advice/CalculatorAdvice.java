package com.javadiscord.challenge.controller.advice;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.javadiscord.challenge.exception.CalculatorException;
import com.javadiscord.challenge.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Will catch exceptions and return appropriate error response.
 * */
@ControllerAdvice
public class CalculatorAdvice {

  @ExceptionHandler(MismatchedInputException.class)
  public ResponseEntity<ErrorResponse> onMismatchedInputException(MismatchedInputException exception) {
    return onCalculatorException(new CalculatorException("values should not contain decimals if type is integer"));
  }

  @ExceptionHandler(ArithmeticException.class)
  public ResponseEntity<ErrorResponse> onMismatchedInputException(ArithmeticException exception) {
    return onCalculatorException(new CalculatorException(exception.getMessage()));
  }

  @ExceptionHandler(CalculatorException.class)
  public ResponseEntity<ErrorResponse> onCalculatorException(CalculatorException exception) {
    return ResponseEntity.badRequest().body(new ErrorResponse(exception.getMessage()));
  }
}
