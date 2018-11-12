package com.adidas.challenge.common.data.input;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CityInput {

    private String origin;
    private Long duration;
    private String destiny;

}
