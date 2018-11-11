package com.adidas.challenge.processor.stream;


import com.adidas.challenge.common.stream.Cities;
import com.adidas.challenge.processor.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CitiesListener {

    private CityService cityService;

    @StreamListener(CitiesStreams.INPUT)
    public void handleCities(@Payload Cities cities) {
        log.info("Received cities: {}", cities);
        cityService.save(cities);
    }

}
