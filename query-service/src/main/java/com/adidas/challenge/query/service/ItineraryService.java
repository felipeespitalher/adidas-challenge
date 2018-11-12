package com.adidas.challenge.query.service;

import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.domain.CityRepository;
import com.adidas.challenge.query.data.ItineraryOutput;
import lombok.AllArgsConstructor;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.InternalPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class ItineraryService {

    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public SuccessOutput search(String originName, String destinyName) {
        notNull(originName, "origin");
        notNull(destinyName, "destiny");

        List<ItineraryOutput> itineraries = new ArrayList<>();
        Iterable<Map<String, Object>> results = cityRepository.findItinerary(originName, destinyName);

        for (Map<String, Object> row : results) {
            InternalPath path = (InternalPath) row.get("p");
            Iterator iterator = path.nodes().iterator();

            InternalNode origin = (InternalNode) iterator.next();
            while (iterator.hasNext()) {
                InternalNode travel = (InternalNode) iterator.next();
                InternalNode destiny = (InternalNode) iterator.next();

                itineraries.add(ItineraryOutput.builder()
                        .origin(origin.get("name").asString())
                        .departure(parseDate(travel.get("departure").asString()))
                        .destiny(destiny.get("name").asString())
                        .arrival(parseDate(travel.get("arrival").asString()))
                        .build());

                origin = destiny;
            }
        }
        return new SuccessOutput(itineraries);
    }


    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

