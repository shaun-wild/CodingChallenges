package com.javadiscord.challenge.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

  /**
   * Reconfigures Spring's ObjectMapper to disallow float to int conversion.
   */
  @Autowired
  public void configureObjectMapper(ObjectMapper objectMapper) {
    objectMapper.disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
  }

}
