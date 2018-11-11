package com.adidas.challenge.event.data.mapper;

import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.event.domain.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class CityInputMapper {

    public CityEntity toCityEntity(CityInput source) {
        CityEntity target = new CityEntity();
        target.setOrigin(source.getOrigin());
        target.setDeparture(source.getDeparture());
        target.setDestiny(source.getDestiny());
        target.setArrival(source.getArrival());
        return target;
    }

}
