package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.answers.Answer;
import com.votingly.votingly-app.model.answers.OpenAnswer;
import com.votingly.votingly-app.model.answers.RangeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer save(OpenAnswer openAnswerEntity);
    Answer save(RangeAnswer rangeAnswerEntity);
}
