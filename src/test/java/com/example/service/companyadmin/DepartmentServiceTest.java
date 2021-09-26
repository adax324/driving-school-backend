package com.example.service.companyadmin;

import com.example.model.companyadmin.City;
import com.example.model.companyadmin.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentServiceTest {
    private CityService cityService;
    private DepartmentService departmentService;
    private City city;
    @Autowired
    public DepartmentServiceTest(CityService cityService, DepartmentService departmentService) {
        this.cityService = cityService;
        this.departmentService = departmentService;
        city=cityService.readCityById(1L);
    }
    //testing at City index 1 make sure there is defined in db

    @Test
    public void shouldCreateNewDepartmentInDB(){
        //given
        Department department=new Department();
        department.setDepartmentCode("BYD01");
        department.setName("Ośrodek szkolenia kierowców");

        city.addNewDepartmentToCity(department);
        //when
        departmentService.createDepartment(department,city);
    }

}