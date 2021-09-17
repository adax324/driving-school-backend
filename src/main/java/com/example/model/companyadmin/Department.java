package com.example.model.companyadmin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String departmentCode;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City departmentCityLocation;

    public void updateFields(Department departmentFields){
        this.name=departmentFields.name;
        this.departmentCode=departmentFields.departmentCode;
        this.departmentCityLocation=departmentFields.departmentCityLocation;
    }

}
