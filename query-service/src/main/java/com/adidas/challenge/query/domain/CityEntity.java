package com.adidas.challenge.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Version;

import java.util.Date;

@Data
@NodeEntity
@NoArgsConstructor
public class CityEntity {

    @GraphId
    private Long id;
    private String origin;
    private Date departure;
    private String destiny;
    private Date arrival;

    @Version
    private Date publishedAt;

}
