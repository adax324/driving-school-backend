package com.example.model;

import com.example.appstarter.department.Department;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Instructor implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String email;
    private int phoneNumber;

    @NotNull
    private String city;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

//    private List<Boolean> drivingLicenseCategoriesOwned;
//    @NotNull
//    private String drivingLicenseNumber;
//
//    private List<Boolean> getDrivingLicenseCategoriesTrainer;
//    @NotNull
//    private String instructorLicenseNumber;
//
//    private boolean isEInstructor;
//    private boolean isActiveEmployee;
//    private boolean isIncludedInNotifications;

    public Instructor(Long id, String firstName, String lastName, Date birthDate, String email, int phoneNumber, String city, Department department/*, String drivingLicenseNumber, String instructorLicenseNumber, boolean isEInstructor, boolean isActiveEmployee, boolean isIncludedInNotifications*/) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.department = department;
//        this.drivingLicenseNumber = drivingLicenseNumber;
//        this.instructorLicenseNumber = instructorLicenseNumber;
//        this.isEInstructor = isEInstructor;
//        this.isActiveEmployee = isActiveEmployee;
//        this.isIncludedInNotifications = isIncludedInNotifications;
    }
}
