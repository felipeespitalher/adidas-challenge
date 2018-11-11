package com.adidas.challenge.common.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CitiesStreams {

    String INPUT = "cities-in";
    String OUTPUT = "cities-out";

    @Input(INPUT)
    SubscribableChannel inboundCities();

    @Output(OUTPUT)
    MessageChannel outboundCities();

}
