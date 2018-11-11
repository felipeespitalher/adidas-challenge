package com.adidas.challenge.command.api;

import com.adidas.challenge.command.stream.CityStreamDispatcher;
import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.output.SuccessOutput;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping(path = "command/v1/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommandApi {

    private final CityStreamDispatcher cityStreamDispatcher;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SuccessOutput create(@Valid @RequestBody CityInput request) {
        return cityStreamDispatcher.sendCities(request);
    }

}
