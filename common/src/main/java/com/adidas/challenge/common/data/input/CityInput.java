package com.adidas.challenge.common.data.input;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CityInput {

    private String origin;
    private Date departure;
    private String destiny;
    private Date arrival;

}
