package com.example.repository.companyadmin;

import com.example.model.companyadmin.City;
import com.example.model.companyadmin.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findAllByDepartmentCityLocation(City city);

}
