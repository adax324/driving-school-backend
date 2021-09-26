package com.example.repository;

import com.example.model.Instructor;
import com.example.model.companyadmin.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Instructor, Long> {

List<Instructor> findAllByDepartment(Department department);

}
