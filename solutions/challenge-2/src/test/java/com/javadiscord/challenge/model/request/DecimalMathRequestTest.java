package com.javadiscord.challenge.model.request;

import com.javadiscord.challenge.model.MathOperation;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.javadiscord.challenge.model.MathOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class DecimalMathRequestTest {

  @Test
  void calculate_add_correctValue() {
    final var input = createMathRequest(ADD, List.of(1F, 5F, 10F));
    assertEquals(16F, input.calculate());
  }

  @Test
  void calculate_sub_correctValue() {
    final var input = createMathRequest(SUB, List.of(10F, 2F, 2F));
    assertEquals(6F, input.calculate());
  }

  @Test
  void calculate_mul_correctValue() {
    final var input = createMathRequest(MUL, List.of(1F, 2F, 3F));
    assertEquals(6F, input.calculate());
  }

  @Test
  void calculate_div_correctValue() {
    final var input = createMathRequest(DIV, List.of(10F, 2F, 2F));
    assertEquals(2.5F, input.calculate());
  }

  private DecimalMathRequest createMathRequest(MathOperation mathOperation, List<Float> values) {
    final var mathRequest = new DecimalMathRequest();
    mathRequest.setValues(values);
    mathRequest.setOperation(mathOperation);
    mathRequest.setType("decimal");
    return mathRequest;
  }
}