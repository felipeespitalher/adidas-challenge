package com.adidas.challenge.controller;

import com.adidas.challenge.data.input.CityInput;
import com.adidas.challenge.data.output.SuccessOutput;
import com.adidas.challenge.service.CityService;
import com.adidas.challenge.stream.Cities;
import com.adidas.challenge.stream.CityStreamService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityStreamService cityStreamService;
    private final CityService cityService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SuccessOutput create(@Valid @RequestBody CityInput request) {

        cityStreamService.sendCities(Cities.builder()
                .origin(request.getOrigin())
                .departure(request.getDeparture())
                .destiny(request.getDestiny())
                .arrival(request.getArrival())
                .build());

        return cityService.create(request);
    }

    @GetMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SuccessOutput get(@PathVariable Long id) {
        return cityService.findById(id);
    }
}
