package com.adidas.challenge.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "DESTINY")
public class CityRelationEntity {

    @GraphId
    private Long id;

    @StartNode
    private TravelEntity travelEntity;

    @EndNode
    private CityEntity cityEntity;

}
