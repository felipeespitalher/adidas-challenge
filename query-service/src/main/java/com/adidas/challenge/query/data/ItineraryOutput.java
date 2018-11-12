package com.adidas.challenge.query.data;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ItineraryOutput {

    private String origin;
    private String destiny;
    private Date departure;
    private Date arrival;

}
