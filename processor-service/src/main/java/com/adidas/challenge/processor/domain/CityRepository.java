package com.adidas.challenge.processor.domain;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CityRepository extends Neo4jRepository<CityEntity, Long> {

}
