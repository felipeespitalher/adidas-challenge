package com.adidas.challenge.processor.service;


import com.adidas.challenge.common.service.AbstractService;
import com.adidas.challenge.common.stream.Cities;
import com.adidas.challenge.domain.CityEntity;
import com.adidas.challenge.domain.TravelEntity;
import com.adidas.challenge.processor.domain.CityRepository;
import com.adidas.challenge.processor.domain.TravelRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.springframework.util.Assert.notNull;


@Service
@AllArgsConstructor
public class CityService extends AbstractService {

    private final CityRepository cityRepository;
    private final TravelRepository travelRepository;

    public void save(Cities payload) {
        notNull(payload, "cities");
        notNull(payload.getOrigin(), "origin");
        notNull(payload.getDuration(), "duration");
        notNull(payload.getDestiny(), "destiny");

        CityEntity origin = findOrCreateByName(payload.getOrigin());
        TravelEntity travel = findOrCreateByDestiny(origin, payload.getDestiny());

        travel.setDuration(payload.getDuration());

        travelRepository.save(travel);

        CityEntity destiny = findOrCreateByName(payload.getDestiny());
        travel.setDestiny(destiny);

        origin.getTravel().add(travel);
        cityRepository.save(origin);
    }

    private CityEntity findOrCreateByName(String cityName) {
        CityEntity cityEntity = cityRepository.findByName(cityName);
        if (cityEntity == null) {
            cityEntity = new CityEntity();
            cityEntity.setName(cityName);
        }
        cityEntity.setTravel(new ArrayList<>());
        return cityEntity;
    }

    private TravelEntity findOrCreateByDestiny(CityEntity origin, String destiny) {
        if (CollectionUtils.isNotEmpty(origin.getTravel())) {
            for (TravelEntity travel : origin.getTravel()) {
                if (travel.getDestiny().getName().equals(destiny)) {
                    return travel;
                }
            }
        }
        return new TravelEntity();
    }

}
