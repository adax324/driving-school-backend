package com.example.appstarter.student;

import com.example.appstarter.department.Department;
import com.example.model.Instructor;
import com.example.utils.NotEmptyId;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
    @NotEmpty
    //@Pattern(regexp = "(^[0-9]{10})")
    private String phoneNumber;
    
    @NotNull
    @ColumnDefault("30.0")
   //@Pattern(regexp = "(^[0-9]{10})")
    private double remainingHours = 30.0;


    private boolean admittedExam = false;


    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @NotEmptyId
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    @ManyToOne
    private Instructor instructor;


    public Map<String, String> getAllStudentFields() {
        Map<String, String> fieldsMap = new HashMap<>();
        if (firstName != null) {
            fieldsMap.put("firstName", firstName);
        } else {
            fieldsMap.put("firstName", "");
        }
        if (lastName != null) {
            fieldsMap.put("lastName", lastName);
        } else {
            fieldsMap.put("lastName", "");
        }
        if (birthDate != null) {
            fieldsMap.put("birthDate", birthDate.toString());
        } else {
            fieldsMap.put("birthDate", "");
        }
        if (email != null) {
            fieldsMap.put("email", email);
        } else {
            fieldsMap.put("email", "");
        }
        if (phoneNumber != null) {
            fieldsMap.put("phoneNumber", phoneNumber);
        } else {
            fieldsMap.put("phoneNumber", "");
        }
        if (instructor.getId() != null) {
            fieldsMap.put("instructor", instructor.getId().toString());
        } else {
            fieldsMap.put("instructor", "");
        }
        return fieldsMap;
    }

}
