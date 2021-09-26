package com.example.model;

import com.example.model.companyadmin.Department;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questId;

    @NotNull
    @NotEmpty
    private String questType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull
    private LocalTime time;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    private Instructor instructor;

    @NotNull
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
