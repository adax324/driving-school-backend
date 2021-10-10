package com.example.appstarter.quest;

import com.example.appstarter.quest.Quest;
import com.example.appstarter.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Long> {
}
