package com.adidas.challenge.data.output;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelError {

  private Integer status;
  private Date timestamp;
  private String message;

}
