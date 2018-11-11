package com.adidas.challenge.common.data.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelError {

  private Integer status;
  private Date timestamp;
  private String message;

}
