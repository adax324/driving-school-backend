package com.example.appstarter.student;

import com.example.appstarter.student.Student;
import com.example.appstarter.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDepartment(Department department);

}
