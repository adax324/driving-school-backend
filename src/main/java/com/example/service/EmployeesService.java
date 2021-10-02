package com.example.service;

import com.example.model.Instructor;
import com.example.model.companyadmin.Department;
import com.example.repository.EmployeesRepository;
import com.example.service.companyadmin.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository, DepartmentService departmentService) {
        this.employeesRepository = employeesRepository;
        this.departmentService = departmentService;
    }

    public List<Instructor> readAllEmployees() {
        return employeesRepository.findAll();
    }

    public void createEmployee(Instructor instructor) {
        employeesRepository.saveAndFlush(instructor);
    }

    public List<Instructor> readAllInstructorsByDepartment(Long id) {
        return employeesRepository.findAllByDepartment(departmentService.readDepartment(id));
    }


    public List<Instructor> readAllInstructorsByDepartment(Department department) {
        return employeesRepository.findAllByDepartment(department);
    }

    public Instructor readInstructorById(Long id) {
        if (employeesRepository.findById(id).isPresent()) {
            return employeesRepository.findById(id).get();
        } else
            return null;
    }


}
