package com.adidas.challenge.query.domain;

import com.adidas.challenge.domain.CityEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CityRepository extends Neo4jRepository<CityEntity, Long> {

    List<CityEntity> findAllByOrigin(String origin);

}
