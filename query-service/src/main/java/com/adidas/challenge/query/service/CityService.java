package com.adidas.challenge.query.service;

import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.query.domain.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public SuccessOutput sendCities(CityInput request) {





        return new SuccessOutput();
    }

}
