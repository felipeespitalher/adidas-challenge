package com.adidas.challenge.event.service;


import com.adidas.challenge.common.data.input.CityInput;
import com.adidas.challenge.common.data.output.SuccessOutput;
import com.adidas.challenge.common.service.AbstractService;
import com.adidas.challenge.event.data.mapper.CityInputMapper;
import com.adidas.challenge.event.domain.CityEntity;
import com.adidas.challenge.event.domain.repository.RepositoryCity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CityService extends AbstractService {

    private final CityInputMapper cityInputMapper;
    private final RepositoryCity repositoryCity;

    public SuccessOutput create(CityInput request) {
        CityEntity entity = cityInputMapper.toCityEntity(request);
        repositoryCity.save(entity);
        return new SuccessOutput();
    }

    public SuccessOutput findById(Long id) {
        Optional<CityEntity> cityEntity = repositoryCity.findById(id);
        return getNonNull("City", id, cityEntity);
    }

}
