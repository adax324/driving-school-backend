package com.example.service;

import com.example.model.Quest;
import com.example.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {
    private QuestRepository questRepository;
    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public List<Quest> readAllQuests(){
        return questRepository.findAll();
    }


    public void createQuest(Quest quest) {
        questRepository.saveAndFlush(quest);
    }
}
