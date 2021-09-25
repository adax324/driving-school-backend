package com.example.service;

import com.example.model.Student;
import com.example.model.companyadmin.City;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        //System.out.println("deleting student on id: " + id);
    }

    public Student getStudentById(Long id){
        if (studentRepository.findById(id).isPresent()){
            return studentRepository.findById(id).get();
        }else
            return null;
    }

    public void editPerson(Student student, Long id) {
        Student editStudent = new Student(
                id,
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate(),
                student.getEmail(),
                student.getPhoneNumber()
        );

        studentRepository.save(editStudent);
        //System.out.println("edit student on id: " + id);
    }


}
