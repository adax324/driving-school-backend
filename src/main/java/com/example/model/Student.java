package com.example.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private Long id;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private String email;
    private int phoneNumber;


}
