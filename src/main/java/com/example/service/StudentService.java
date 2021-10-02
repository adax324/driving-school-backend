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

    public void createStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    public Student readStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student readStudentById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        } else
            return null;
    }

    public void updateStudent(Long id, Student student) {
        Student studentToEdit = studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        studentToEdit.setFirstName(student.getFirstName());
        studentToEdit.setLastName(student.getLastName());
        studentToEdit.setBirthDate(student.getBirthDate());
        studentToEdit.setEmail(student.getEmail());
        studentToEdit.setPhoneNumber(student.getPhoneNumber());
        studentToEdit.setDepartment(student.getDepartment());
        studentToEdit.setInstructor(student.getInstructor());
        studentRepository.saveAndFlush(studentToEdit);
    }


    public List<Student> readStudentByDepartmentId(Long id) {
        return studentRepository.findAllByDepartment(departmentService.readDepartment(id));
    }

    public List<Student> readStudentByDepartmentId(Department department) {
        return studentRepository.findAllByDepartment(department);
    }


}
