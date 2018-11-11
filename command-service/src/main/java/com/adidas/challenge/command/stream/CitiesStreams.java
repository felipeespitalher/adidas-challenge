package com.adidas.challenge.command.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CitiesStreams {

    String OUTPUT = "cities-out";

    @Output(OUTPUT)
    MessageChannel outboundCities();

}
