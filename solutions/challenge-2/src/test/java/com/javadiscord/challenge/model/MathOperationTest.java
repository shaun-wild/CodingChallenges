package com.javadiscord.challenge.model;

import com.javadiscord.challenge.exception.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathOperationTest {

  @Test
  void fromString_operationExists_returnsOperation() {
    final var input = "add";
    final var result = MathOperation.fromString(input);
    assertEquals(MathOperation.ADD, result);
  }

  @Test
  void fromString_operationNotExists_throwsCalculatorException() {
    final var input = "test";
    assertThrows(CalculatorException.class, () -> MathOperation.fromString(input));
  }

  @Test
  void fromString_null_returnsNull() {
    final String input = null;
    final var result = MathOperation.fromString(input);
    assertNull(result);
  }
}