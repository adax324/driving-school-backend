package com.example.model;

import com.example.model.companyadmin.Department;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questId;

    @NotNull(message = "isNull")
    @NotEmpty(message = "isEmpty")
    private String questType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "isNull")
    private LocalTime time;

    @NotNull(message = "isNull")
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @NotNull(message = "isNull")
    @ManyToOne
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public boolean updateFields(Quest updatedQuest) {
        if (updatedQuest != null && updatedQuest.questType != null && updatedQuest.date != null && updatedQuest.time != null) {
            this.questType = updatedQuest.questType;
            this.date = updatedQuest.date;
            this.time = updatedQuest.time;
            return true;
        } else
            return false;


    }

}
