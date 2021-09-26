package com.example.service.companyadmin;

import com.example.model.companyadmin.City;
import com.example.repository.companyadmin.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city) {
        return cityRepository.saveAndFlush(city);
    }

    public List<City> readAllCities() {
        return cityRepository.findAll();
    }

    public City readCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(NoSuchElementException::new);


    }
}