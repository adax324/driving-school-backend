package com.example.contoller;

import com.example.model.companyadmin.City;
import com.example.service.companyadmin.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityTempController {
    private CityService cityService;
    @Autowired
    public CityTempController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/test")
    public City getCities(){
        return cityService.getCityById(1L);
    }
}
