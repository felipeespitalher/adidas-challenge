package com.adidas.challenge.processor.domain;

import com.adidas.challenge.domain.CityEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CityRepository extends Neo4jRepository<CityEntity, Long> {

    CityEntity findByName(String name);

}
