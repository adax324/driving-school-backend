package com.example.model;

import com.example.model.companyadmin.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String questType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalTime time;


    private Long studentId = 1L;//temp
    private Long teacherId = 1L;//temp
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
