package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer save(Answer answer);
}
