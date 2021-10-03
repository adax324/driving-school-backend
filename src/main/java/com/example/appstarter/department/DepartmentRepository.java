package com.example.appstarter.department;

import com.example.appstarter.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findAllByDepartmentCityLocation(City city);

}
