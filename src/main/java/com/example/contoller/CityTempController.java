package com.example.contoller;

import com.example.model.City;
import com.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityTempController {
    private CityService cityService;
    @Autowired
    public CityTempController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/xd")
    public City getCities(){
        return cityService.getCityById(1L);
    }
}
