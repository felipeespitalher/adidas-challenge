package com.adidas.challenge.common.data.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@ApiModel(value = "ItineraryInput", description = "ItineraryInput - payload for itineraries ")
public class ItineraryInput {

    @ApiModelProperty(example = "Lisbon", notes = "Origin city")
    private String origin;
    @ApiModelProperty(example = "2018-04-10T04:00:00.000Z", notes = "Departure datetime")
    private Date departure;
    @ApiModelProperty(example = "Zaragoza", notes = "Destiny city")
    private String destiny;
    @ApiModelProperty(example = "2018-04-10T04:00:00.000Z", notes = "Arrival datetime")
    private Date arrival;

}
