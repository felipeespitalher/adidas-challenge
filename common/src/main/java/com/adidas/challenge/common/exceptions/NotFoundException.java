package com.adidas.challenge.common.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String type;
  private Object id;

  @Override
  public String getMessage() {
    return String.format("%s id %s not found", type, id);
  }

}
