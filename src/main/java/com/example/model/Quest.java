package com.example.model;

import com.example.model.companyadmin.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questId;
    private String questName;

    private LocalDate date;
    private LocalTime time;


    private Long studentId=1L;//temp
    private Long teacherId=1L;//temp
    @ManyToOne
    @JoinColumn(name = "id")
    private Department department;



}
