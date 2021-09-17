package com.example.service.companyadmin;

import com.example.model.companyadmin.City;
import com.example.model.companyadmin.Department;
import com.example.repository.companyadmin.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private CityService cityService;
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(CityService cityService, DepartmentRepository departmentRepository) {
        this.cityService = cityService;
        this.departmentRepository = departmentRepository;
    }
    public Department createDepartment(Department department, City city){
        department.setDepartmentCityLocation(city);
        return departmentRepository.saveAndFlush(department);
    }
    public Department readDepartment(Long id){
        return departmentRepository.findById(id).orElse(null);

    }
    public List<Department> readAllDepartments(){
        return departmentRepository.findAll();
    }
    public Department updateDepartment(Department department,Long id){
        Department editedDepartment=departmentRepository.findById(id).orElse(null);
        editedDepartment.updateFields(department);
        return editedDepartment;
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}
