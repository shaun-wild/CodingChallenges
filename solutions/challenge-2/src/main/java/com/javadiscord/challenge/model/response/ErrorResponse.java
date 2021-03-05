package com.javadiscord.challenge.model.response;

import lombok.Data;

/**
 * Model used to represent an error response.
 * */
@Data
public class ErrorResponse {
  private final String error;
}
