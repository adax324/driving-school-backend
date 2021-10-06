package com.example.appstarter.student;

import com.example.appstarter.department.Department;
import com.example.model.Instructor;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20, message
            = "Imie musi zawierać od 1 do 20 liter")
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20, message
            = "Nazwisko musi zawierać od 1 do 20 liter")
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Email(message = "Niepoprawny adres email")
    private String email;
    @NotNull
    //@Pattern(regexp = "(^[0-9]{10})")
    private int phoneNumber;
    @NotNull
    @ColumnDefault("30.0")
   //@Pattern(regexp = "(^[0-9]{10})")
    private double remainingHours = 30.0;


    private boolean admittedExam;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @NotNull
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    @ManyToOne
    private Instructor instructor;


}
