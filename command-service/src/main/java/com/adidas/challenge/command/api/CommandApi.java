package com.adidas.challenge.command.api;

import com.adidas.challenge.command.stream.CityStreamDispatcher;
import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.output.ModelError;
import com.adidas.challenge.common.data.output.SuccessOutput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping(path = "command/v1/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommandApi {

    private final CityStreamDispatcher cityStreamDispatcher;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create itinerary", notes = "create one itinerary")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SuccessOutput.class),
            @ApiResponse(code = 404, message = "Not Found", response = ModelError.class),
            @ApiResponse(code = 417, message = "Expectation Failed", response = ModelError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ModelError.class)
    })
    public SuccessOutput createByOne(@Valid @RequestBody CityInput request) {
        return cityStreamDispatcher.sendCities(request);
    }

    @PostMapping(path = "list", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a list of itineraries", notes = "create a list of itineraries")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SuccessOutput.class),
            @ApiResponse(code = 404, message = "Not Found", response = ModelError.class),
            @ApiResponse(code = 417, message = "Expectation Failed", response = ModelError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ModelError.class)
    })
    public SuccessOutput createByList(@Valid @RequestBody List<CityInput> request) {
        return cityStreamDispatcher.sendCities(request);
    }

}
