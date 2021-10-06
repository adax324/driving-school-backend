package com.example.appstarter.quest;

import com.example.service.EmployeesService;
import com.example.appstarter.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestService {
    private final QuestRepository questRepository;
    private final StudentService studentService;
    private final EmployeesService employeesService;

    @Autowired
    public QuestService(QuestRepository questRepository, StudentService studentService, EmployeesService employeesService) {
        this.questRepository = questRepository;
        this.studentService = studentService;
        this.employeesService = employeesService;
    }

    public void createQuest(Quest quest) {
        questRepository.saveAndFlush(quest);
    }

    public Quest readQuest(Long id) {
        return questRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Quest> readAllQuests() {
        return questRepository.findAll();
    }

    public Quest updateQuest(Long id, Quest updatedQuest) {

        Quest currentQuest = questRepository.findById(id).orElseThrow(NoSuchElementException::new);
        currentQuest.setStudent(studentService.readStudent(updatedQuest.getStudent().getId())); //zmiana studenta
        currentQuest.setInstructor(employeesService.readInstructorById(updatedQuest.getInstructor().getId())); //poproszę metodę do pobrania instruktora po ID
        currentQuest.updateFields(updatedQuest);
        return questRepository.saveAndFlush(currentQuest);

    }
    public void deleteQuest(Long id){
        questRepository.deleteById(id);
    }

}
