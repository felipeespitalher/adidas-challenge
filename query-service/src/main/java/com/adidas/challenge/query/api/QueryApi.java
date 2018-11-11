package com.adidas.challenge.query.api;

import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.query.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "query/v1/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryApi {

    private final CityService cityService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SuccessOutput create(@Valid @RequestBody CityInput request) {
        return cityService.sendCities(request);
    }


}
