package com.adidas.challenge.domain;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CityRepository extends Neo4jRepository<CityEntity, Long> {

    CityEntity findByName(String name);

}
