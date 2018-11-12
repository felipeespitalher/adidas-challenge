package com.adidas.challenge.common.data.mapper;

import com.adidas.challenge.common.data.input.ItineraryInput;
import com.adidas.challenge.common.stream.Cities;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public Cities toCities(ItineraryInput itineraryInput) {
        return Cities.builder()
                .origin(itineraryInput.getOrigin())
                .departure(itineraryInput.getDeparture())
                .destiny(itineraryInput.getDestiny())
                .arrival(itineraryInput.getArrival())
                .build();
    }

}