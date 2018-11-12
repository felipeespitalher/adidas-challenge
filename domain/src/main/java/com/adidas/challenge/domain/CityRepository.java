package com.adidas.challenge.domain;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CityRepository extends Neo4jRepository<CityEntity, Long> {

    CityEntity findByName(String name);


    @Query("MATCH (origin:CityEntity),(destiny:CityEntity), p = shortestPath((origin)-[*..]-(destiny)) " +
            "WHERE origin.name =~ {0} AND destiny.name =~ {1} RETURN p")
    Iterable<Map<String, Object>> findItinerary(String origin, String destiny);

}
