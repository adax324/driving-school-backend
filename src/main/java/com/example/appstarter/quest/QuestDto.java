package com.example.appstarter.quest;

import com.example.appstarter.department.Department;
import com.example.model.Instructor;
import com.example.model.Student;

import java.time.LocalDate;
import java.time.LocalTime;

public class QuestDto {
    private Long questId;
    private String questType;
    private LocalDate date;
    private LocalTime time;
    private Student student;
    private Instructor instructor;
    private Department department;
}
