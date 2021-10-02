package com.example.service;

import com.example.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    private StudentService studentService;

    @Autowired
    StudentServiceTest(StudentService studentService) {
        this.studentService = studentService;
    }

    @Test
    void shouldAddedStudentToList(){
        //given
        Student student = new Student();
        student.setFirstName("Pablo");
        student.setLastName("Pablitto");
        //student.setBirthDate(1933-11-01);
        student.setPhoneNumber(231123412);
        student.setEmail("Pablo");
        //when
      //  Long newStudentId= studentService.createStudent(student).getId();
        //Student createdStudent=studentService.readStudentById(newStudentId);
        //then
    //    assertEquals(student.getFirstName(),createdStudent.getFirstName());



    }


}