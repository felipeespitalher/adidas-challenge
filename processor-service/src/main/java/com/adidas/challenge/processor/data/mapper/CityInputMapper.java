package com.adidas.challenge.processor.data.mapper;

import com.adidas.challenge.common.stream.Cities;
import com.adidas.challenge.processor.domain.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class CityInputMapper {

    public CityEntity toCityEntity(Cities source) {
        CityEntity target = new CityEntity();
        target.setOrigin(source.getOrigin());
        target.setDeparture(source.getDeparture());
        target.setDestiny(source.getDestiny());
        target.setArrival(source.getArrival());
        target.setPublishedAt(source.getPublishedAt());
        return target;
    }

}
