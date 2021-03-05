package com.javadiscord.challenge.controller;

import com.javadiscord.challenge.model.request.MathRequest;
import com.javadiscord.challenge.model.response.MathResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CalculatorController {

  @PostMapping("/calculate")
  public ResponseEntity<?> calculate(@RequestBody MathRequest<?> mathRequest) {
    final var result = mathRequest.calculate();
    return ok(new MathResponse(result));
  }
}
