package com.javadiscord.challenge.model.request;

import java.math.BigDecimal;

/**
 * Safe math request, will be instantiated if the type is "safe".
 */
public class SafeMathRequest extends MathRequest<BigDecimal> {

  /**
   * {@inheritDoc}
   */
  @Override
  public BigDecimal calculate() {
    final var floatStream = getValues()
      .stream();

    return switch (getOperation()) {
      case ADD -> floatStream.reduce(BigDecimal::add).orElseThrow();
      case SUB -> floatStream.reduce(BigDecimal::subtract).orElseThrow();
      case MUL -> floatStream.reduce(BigDecimal::multiply).orElseThrow();
      case DIV -> floatStream.reduce(BigDecimal::divide).orElseThrow();
    };
  }
}
