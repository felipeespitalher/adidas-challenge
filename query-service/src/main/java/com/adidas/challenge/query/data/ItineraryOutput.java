package com.adidas.challenge.query.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@ApiModel(value = "ItineraryOutput", description = "ItineraryOutput - payload for itineraries ")
public class ItineraryOutput {

    @ApiModelProperty(example = "Lisbon", notes = "Origin city")
    private String origin;

    @ApiModelProperty(example = "2018-04-10T04:00:00.000Z", notes = "Departure datetime")
    private Date departure;

    @ApiModelProperty(example = "Zaragoza", notes = "Destiny city")
    private String destiny;

    @ApiModelProperty(example = "2018-04-10T04:00:00.000Z", notes = "Arrival datetime")
    private Date arrival;

}
