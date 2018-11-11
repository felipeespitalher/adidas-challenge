package com.adidas.challenge.stream;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CitiesListener {

    @StreamListener(CitiesStreams.INPUT)
    public void handleGreetings(@Payload Cities cities) {
        log.info("Received cities: {}", cities);
    }

}
