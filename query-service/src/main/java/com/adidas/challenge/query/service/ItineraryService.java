package com.adidas.challenge.query.service;

import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.query.domain.CityEntity;
import com.adidas.challenge.query.domain.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class ItineraryService {

    private final CityRepository cityRepository;

    public SuccessOutput search(String origin, String destiny) {
        notNull(origin, "origin");
        notNull(destiny, "destiny");
        List<CityEntity> result = cityRepository.findAllByOrigin(origin);
        return new SuccessOutput(result);
    }

}
