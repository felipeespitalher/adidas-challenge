package com.adidas.challenge.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.List;

@Data
@NodeEntity
@NoArgsConstructor
public class CityEntity {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;

    private Date publishedAt;

    @Relationship(type = "TRAVEL")
    private List<TravelEntity> travel;

}
