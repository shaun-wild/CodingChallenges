package com.javadiscord.challenge.model.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.javadiscord.challenge.model.MathOperation;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

/**
 * Generic, abstract base class for all incoming requests, uses Jackson's {@link JsonTypeInfo} to decide the sub-class
 * to instantiate.
 *
 * @see DecimalMathRequest
 * @see IntegerMathRequest
 * @see SafeMathRequest
 */
@Data
@JsonTypeInfo(use = NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = DecimalMathRequest.class, name = "decimal"),
  @JsonSubTypes.Type(value = IntegerMathRequest.class, name = "integer"),
  @JsonSubTypes.Type(value = SafeMathRequest.class, name = "safe")
})
public abstract class MathRequest<T extends Number> {
  protected List<T> values;
  protected String type;
  protected MathOperation operation;

  /**
   * Will apply operation to values.
   *
   * @return the result of applying the operation to the values.
   */
  public abstract T calculate();
}
