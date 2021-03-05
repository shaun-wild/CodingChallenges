package com.javadiscord.challenge.exception;

/**
 * Domain exception, will be caught by {@link com.javadiscord.challenge.controller.advice.CalculatorAdvice} and
 * returned as an {@link com.javadiscord.challenge.model.response.ErrorResponse}.
 *
 * @see com.javadiscord.challenge.model.response.ErrorResponse
 * @see com.javadiscord.challenge.controller.advice.CalculatorAdvice
 */
public class CalculatorException extends ArithmeticException {
  public CalculatorException(String message) {
    super(message);
  }
}
