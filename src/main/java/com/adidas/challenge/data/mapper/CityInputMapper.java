package com.adidas.challenge.data.mapper;

import com.adidas.challenge.data.input.CityInput;
import com.adidas.challenge.domain.CityEntity;
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
