package com.adidas.challenge.stream;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Service
@AllArgsConstructor
public class CityStreamService {

    private final CitiesStreams citiesStreams;


    public void sendCities(final Cities cities) {
        log.info("Sending cities {}", cities);
        MessageChannel messageChannel = citiesStreams.outboundCities();
        messageChannel.send(MessageBuilder
                .withPayload(cities)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }


}
