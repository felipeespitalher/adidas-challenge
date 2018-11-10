package com.adidas.challenge.service;


import com.adidas.challenge.common.AbstractService;
import com.adidas.challenge.data.input.CityInput;
import com.adidas.challenge.data.mapper.CityInputMapper;
import com.adidas.challenge.data.output.SuccessOutput;
import com.adidas.challenge.domain.CityEntity;
import com.adidas.challenge.domain.repository.RepositoryCity;
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
