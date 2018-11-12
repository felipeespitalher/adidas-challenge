package com.adidas.challenge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity
@NoArgsConstructor
public class CityEntity {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;

    @Relationship(type = "TRAVEL")
    private List<TravelEntity> travel;

    public List<TravelEntity> getTravel() {
        if (travel == null) {
            travel = new ArrayList<>();
        }
        return travel;
    }

}
