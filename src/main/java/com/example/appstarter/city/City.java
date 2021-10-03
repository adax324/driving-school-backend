package com.example.appstarter.city;

import com.example.appstarter.department.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cityId;
    private String cityName;
    @OneToMany(mappedBy = "departmentCityLocation", cascade = CascadeType.REMOVE , fetch = FetchType.EAGER)
    private List<Department> departmentList=new LinkedList<>();

    public City(String cityName, List<Department> departmentList) {
        this.cityName = cityName;
        this.departmentList = departmentList;
    }
    public List<Department> addNewDepartmentToCity(Department department){
        departmentList.add(department);
        return departmentList;
    }
}
