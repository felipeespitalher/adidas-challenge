package com.adidas.challenge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;

@Data
@NodeEntity
@NoArgsConstructor
public class TravelEntity {

    @GraphId
    private Long id;
    private Long duration;
    private Date publishedAt;

    @Relationship(type = "DESTINY")
    private CityEntity destiny;

}
