package com.adidas.challenge.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "TRAVEL")
public class TravelRelationEntity {

    @GraphId
    private Long id;

    @StartNode
    private CityEntity cityEntity;

    @EndNode
    private TravelEntity travelEntity;

}
