package com.javadiscord.challenge.model.request;

/**
 * Integer math request, will be instantiated if the type is "integer".
 */
public class IntegerMathRequest extends MathRequest<Integer> {

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer calculate() {
    final var intStream = getValues()
      .stream()
      .mapToInt(Integer::valueOf);

    return switch (getOperation()) {
      case ADD -> intStream.sum();
      case SUB -> intStream.reduce((a, b) -> a - b).orElseThrow();
      case MUL -> intStream.reduce((a, b) -> a * b).orElseThrow();
      case DIV -> intStream.reduce((a, b) -> a / b).orElseThrow();
    };
  }
}
