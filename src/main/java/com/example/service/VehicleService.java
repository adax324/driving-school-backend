package com.example.service;

import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
}
