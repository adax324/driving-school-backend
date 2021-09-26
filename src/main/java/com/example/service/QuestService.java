package com.example.service;

import com.example.model.Quest;
import com.example.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestService {
    private final QuestRepository questRepository;

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
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

        return questRepository.saveAndFlush(currentQuest);

    }

}
