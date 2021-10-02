package com.example.service;

import com.example.model.Student;
import com.example.model.companyadmin.Department;
import com.example.repository.StudentRepository;
import com.example.service.companyadmin.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentService departmentService;

    @Autowired
    public StudentService(StudentRepository studentRepository, DepartmentService departmentService) {
        this.studentRepository = studentRepository;
        this.departmentService = departmentService;
    }

    public List<Student> readAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public Student readStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        //System.out.println("deleting student on id: " + id);
    }

    public Student readStudentById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        } else
            return null;
    }

    public void editPerson(Student student, Long id) {
        Student editStudent = new Student(
                id,
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getDepartment()
        );
        studentRepository.save(editStudent);
    }


    public List<Student> readStudentByDepartmentId(Long id) {
        return studentRepository.findAllByDepartment(departmentService.readDepartment(id));
    }

    public List<Student> readStudentByDepartmentId(Department department) {
        return studentRepository.findAllByDepartment(department);
    }


}
