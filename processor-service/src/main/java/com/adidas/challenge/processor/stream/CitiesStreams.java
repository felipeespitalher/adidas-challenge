package com.adidas.challenge.processor.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CitiesStreams {

    String INPUT = "cities-in";

    @Input(INPUT)
    SubscribableChannel inboundCities();

}
