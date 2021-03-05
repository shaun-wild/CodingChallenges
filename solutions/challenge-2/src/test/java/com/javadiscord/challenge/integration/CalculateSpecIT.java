package com.javadiscord.challenge.integration;

import com.javadiscord.challenge.model.MathOperation;
import com.javadiscord.challenge.model.request.DecimalMathRequest;
import com.javadiscord.challenge.model.request.IntegerMathRequest;
import com.javadiscord.challenge.model.request.SafeMathRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CalculateSpecIT extends BaseSpecIT {

  @Test
  void integer_returnsCorrectResponse() throws Exception {
    final var request = new IntegerMathRequest();
    request.setOperation(MathOperation.ADD);
    request.setValues(List.of(1, 2, 3, 4));

    mockMvc.perform(post("/calculate")
      .content(asJsonString(request))
      .header("Content-Type", "application/json"))
      .andDo(print()).andExpect(status().isOk())
      .andExpect(jsonPath("$.result").value(10))
      .andReturn();
  }

  @Test
  void decimal_returnsCorrectResponse() throws Exception {
    final var request = new DecimalMathRequest();
    request.setOperation(MathOperation.SUB);
    request.setValues(List.of(50F, 10F, 10F));

    mockMvc.perform(post("/calculate")
      .content(asJsonString(request))
      .header("Content-Type", "application/json"))
      .andDo(print()).andExpect(status().isOk())
      .andExpect(jsonPath("$.result").value(30F))
      .andReturn();
  }

  @Test
  void safe_returnsCorrectResponse() throws Exception {
    final var request = new SafeMathRequest();
    request.setOperation(MathOperation.ADD);
    request.setValues(List.of(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE));

    mockMvc.perform(post("/calculate")
      .content(asJsonString(request))
      .header("Content-Type", "application/json"))
      .andDo(print()).andExpect(status().isOk())
      .andExpect(jsonPath("$.result").value(12))
      .andReturn();
  }

  @Test
  public void integer_failsOnDecimal() throws Exception {
    final var input = """
      {
        "type": "integer",
        "values": [5, 5.5],
        "operation": "add"
      }
      """;

    mockMvc.perform(post("/calculate")
      .content(input)
      .header("Content-Type", "application/json"))
      .andDo(print()).andExpect(status().isBadRequest())
      .andExpect(jsonPath("$.error").value("values should not contain decimals if type is integer"))
      .andReturn();
  }

  @Test
  public void invalidOperation_fails() throws Exception {
    final var input = """
      {
        "type": "integer",
        "values": [10, 5],
        "operation": "modulo"
      }
      """;

    mockMvc.perform(post("/calculate")
      .content(input)
      .header("Content-Type", "application/json"))
      .andDo(print()).andExpect(status().isBadRequest())
      .andExpect(jsonPath("$.error").value("Invalid operation: modulo"))
      .andReturn();
  }

}
