package com.adidas.challenge.processor.domain;

import com.adidas.challenge.domain.TravelEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TravelRepository extends Neo4jRepository<TravelEntity, Long> {
}
