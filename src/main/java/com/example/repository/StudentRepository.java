package com.example.repository;

import com.example.model.Student;
import com.example.model.companyadmin.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDepartment(Department department);

}
