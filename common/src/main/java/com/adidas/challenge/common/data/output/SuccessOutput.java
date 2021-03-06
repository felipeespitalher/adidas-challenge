package com.adidas.challenge.common.data.output;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SuccessOutput implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonUnwrapped
    private Object payload;


}
