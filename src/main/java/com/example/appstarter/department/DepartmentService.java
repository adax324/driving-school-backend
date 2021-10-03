package com.example.appstarter.department;

import com.example.appstarter.city.CityService;
import com.example.appstarter.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {
    private final CityService cityService;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(CityService cityService, DepartmentRepository departmentRepository) {
        this.cityService = cityService;
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department, City city) {
        if (city == null) {
            throw new NoSuchElementException("City not exists");
        }
        department.setDepartmentCityLocation(city);
        return departmentRepository.saveAndFlush(department);
    }

    public Department readDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    public List<Department> readAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Department> readAllDepartmentsByCity(City city) {
        return departmentRepository.findAllByDepartmentCityLocation(city);

    }

    public Department updateDepartment(Department department, Long id) {
        Department editedDepartment = departmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (department == null) {
            throw new NoSuchElementException("such department not exists");
        }
        editedDepartment.updateFields(department);
        return editedDepartment;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


}
