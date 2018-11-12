package com.adidas.challenge.query.service;

import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.domain.CityEntity;
import com.adidas.challenge.domain.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class ItineraryService {

    private final CityRepository cityRepository;

    public SuccessOutput search(String origin, String destiny) {
        notNull(origin, "origin");
        notNull(destiny, "destiny");


        CityEntity start = cityRepository.findByName(origin);


//        List<CityEntity> result = cityRepository.findItinerary(origin);

        return new SuccessOutput();
    }

//    private boolean hasPathBFS() {
//
//    }


    public class Result {

        private String origin;
        private String destiny;
        private

    }
}

