package com.example.service.companyadmin;

import com.example.model.companyadmin.City;
import com.example.repository.companyadmin.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private CityRepository cityRepository;
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public City addCity(City city){
       return cityRepository.saveAndFlush(city);
    }
    public List<City> getAllCities(){
        List<City> cities=cityRepository.findAll();
        System.out.println(cities);
        return cities;
    }
    public City getCityById(Long id){
        if (cityRepository.findById(id).isPresent()){
            return cityRepository.findById(id).get();
        }else
            return null;
    }
}
