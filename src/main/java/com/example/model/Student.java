package com.example.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    private Date birthDate;

    @Email(message = "Niepoprawny adres email")
    private String email;

    @Pattern(regexp = "(^[0-9]{10})")
    private int phoneNumber;

    public Student(Long id, String firstName, String lastName, Date birthDate, String email, int phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }
}
