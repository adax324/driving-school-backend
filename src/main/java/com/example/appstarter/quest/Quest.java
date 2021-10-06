package com.example.appstarter.quest;

import com.example.model.Instructor;
import com.example.appstarter.student.Student;
import com.example.appstarter.department.Department;
import com.example.utils.NotEmptyId;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questId;

    @NotEmpty(message = "isEmpty")
    private String questType;
    @NotNull(message = "isNull")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "isNull")
    private LocalTime time;

    @NotEmptyId
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @NotEmptyId
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

    public Map<String, String> getAllFields() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put("questType", questType);
        if (date != null) {
            fieldsMap.put("date", date.toString());
        } else {
            fieldsMap.put("date", "");
        }
        if (time != null) {
            fieldsMap.put("time", time.toString());
        } else {
            fieldsMap.put("time", "");
        }
        if (student.getId() != null) {
            fieldsMap.put("student", student.getId().toString());
        } else {

            fieldsMap.put("student", "");
        }
        if (instructor.getId() != null) {
            fieldsMap.put("instructor", instructor.getId().toString());
        } else {
            fieldsMap.put("instructor", "");
        }
        return fieldsMap;

    }

}
