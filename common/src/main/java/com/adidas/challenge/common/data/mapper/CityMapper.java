package com.adidas.challenge.common.data.mapper;

import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.stream.Cities;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CityMapper {

    public Cities toCities(CityInput cityInput) {
        return Cities.builder()
                .origin(cityInput.getOrigin())
                .departure(cityInput.getDeparture())
                .destiny(cityInput.getDestiny())
                .arrival(cityInput.getArrival())
                .publishedAt(new Date())
                .build();
    }

}