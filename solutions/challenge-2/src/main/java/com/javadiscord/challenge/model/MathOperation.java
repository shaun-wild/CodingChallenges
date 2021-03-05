package com.javadiscord.challenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.javadiscord.challenge.exception.CalculatorException;

import static java.lang.String.format;

/**
 * Simple enum representing four arithmetic operations.
 * */
public enum MathOperation {
  ADD, SUB, MUL, DIV;

  private static final String ERROR_FORMAT = "Invalid operation: %s";

  /**
   * {@link JsonCreator} method for Jackson to allow creation of this enum, whilst disregarding case.
   * @throws CalculatorException if the given key is not a valid operation.
   * */
  @JsonCreator
  @SuppressWarnings("unused")
  public static MathOperation fromString(String key) {
    try {
      return key == null ? null : valueOf(key.toUpperCase());
    }catch(IllegalArgumentException ex) {
      throw new CalculatorException(format(ERROR_FORMAT, key));
    }
  }
}
