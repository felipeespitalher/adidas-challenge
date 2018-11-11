package com.adidas.challenge.query.api;

import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.query.service.ItineraryService;
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

    @GetMapping(path = "/itinerary/{origin}/{destiny}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SuccessOutput create(@PathVariable String origin, @PathVariable String destiny) {
        return itineraryService.search(origin, destiny);
    }

}
