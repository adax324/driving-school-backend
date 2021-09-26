package com.example.contoller;

import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;
import com.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleRepository vehicleRepository;
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository, VehicleService vehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
    }


    @GetMapping("/list")
    public String getVehiclesList(Model model) {
        List<Vehicle> list = vehicleRepository.findAll();
        model.addAttribute("vehicle", list);
        return "/admin/vehicles/vehiclesList";
    }

    @GetMapping("/addNewVehicle")
    public String getAddNewVehicle() {
        return "/admin/vehicles/addNewVehicle";
    }


    @PostMapping("/addNewPerson")
    public RedirectView postAddNewVehicle(@ModelAttribute Vehicle newVehicle) {
        vehicleRepository.save(newVehicle);
        return new RedirectView("/vehicleList");
    }

    @GetMapping("/editPerson/{id}")
    public String getEditVehicle(@PathVariable String id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicle(Long.parseLong(id)));
        return "/admin/vehicles/editVehicle";
    }



}