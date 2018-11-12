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
                .duration(cityInput.getDuration())
                .destiny(cityInput.getDestiny())
                .publishedAt(new Date())
                .build();
    }

}