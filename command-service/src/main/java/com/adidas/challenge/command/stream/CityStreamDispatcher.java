package com.adidas.challenge.command.stream;

import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.mapper.CityMapper;
import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.common.service.AbstractService;
import com.adidas.challenge.common.stream.Cities;
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
public class CityStreamDispatcher extends AbstractService {

    private final CitiesStreams citiesStreams;
    private final CityMapper cityMapper;

    public SuccessOutput sendCities(final CityInput request) {
        log.info("Sending cities {}", request);

        Cities cities = cityMapper.toCities(request);

        if (dispatch(cities)) {
            return new SuccessOutput();
        } else {
            throw new RuntimeException("Couldn't persist data");
        }
    }

    private boolean dispatch(Cities cities) {
        MessageChannel messageChannel = citiesStreams.outboundCities();
        return messageChannel.send(MessageBuilder
                .withPayload(cities)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

}
