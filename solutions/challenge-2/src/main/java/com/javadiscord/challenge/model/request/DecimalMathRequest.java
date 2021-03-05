package com.javadiscord.challenge.model.request;

/**
 * Decimal math request, will be instantiated if the type is "decimal".
 */
public class DecimalMathRequest extends MathRequest<Float> {

  /**
   * {@inheritDoc}
   */
  @Override
  public Float calculate() {
    final var floatStream = getValues()
      .stream();

    return switch (getOperation()) {
      case ADD -> floatStream.reduce((a, b) -> a + b).orElseThrow();
      case SUB -> floatStream.reduce((a, b) -> a - b).orElseThrow();
      case MUL -> floatStream.reduce((a, b) -> a * b).orElseThrow();
      case DIV -> floatStream.reduce((a, b) -> a / b).orElseThrow();
    };
  }
}
