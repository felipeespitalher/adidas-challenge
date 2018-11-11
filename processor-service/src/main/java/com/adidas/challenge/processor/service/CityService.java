package com.adidas.challenge.processor.service;


import com.adidas.challenge.common.service.AbstractService;
import com.adidas.challenge.common.stream.Cities;
import com.adidas.challenge.processor.data.mapper.CityInputMapper;
import com.adidas.challenge.processor.domain.CityEntity;
import com.adidas.challenge.processor.domain.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CityService extends AbstractService {

    private final CityRepository cityRepository;
    private final CityInputMapper cityInputMapper;

    public void save(Cities payload) {
        CityEntity entity = cityInputMapper.toCityEntity(payload);
        cityRepository.save(entity);
    }

}
