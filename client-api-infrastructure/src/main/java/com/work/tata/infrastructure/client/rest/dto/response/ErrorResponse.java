package com.work.tata.infrastructure.client.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
  Integer code;
  String message;
}
