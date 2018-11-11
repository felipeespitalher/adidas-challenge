package com.adidas.challenge.event.domain.repository;

import com.adidas.challenge.event.domain.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryCity extends CrudRepository<CityEntity, Long> {

    Optional<CityEntity> findById(Long id);

}
