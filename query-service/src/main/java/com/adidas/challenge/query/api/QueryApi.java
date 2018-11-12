package com.adidas.challenge.query.api;

import com.adidas.challenge.common.data.output.ErrorOutput;
import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.query.data.ItineraryOutput;
import com.adidas.challenge.query.service.ItineraryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "query/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class QueryApi {

    private final ItineraryService itineraryService;

    @GetMapping(path = "/itinerary/{origin}/{destiny}")
    @ApiOperation(value = "Search Itinerary", notes = "search itinerary by Origin city and Destiny City")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ItineraryOutput.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorOutput.class),
            @ApiResponse(code = 417, message = "Expectation Failed", response = ErrorOutput.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorOutput.class)
    })
    public SuccessOutput search(@PathVariable String origin, @PathVariable String destiny) {
        return itineraryService.search(origin, destiny);
    }

}
