package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.answers.Answer;
import com.votingly.votingly-app.model.answers.OpenAnswer;
import com.votingly.votingly-app.model.answers.RangeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>, FindAllAnswersBySurveyId {
//    Answer save(OpenAnswer openAnswerEntity);
//
//    Answer save(RangeAnswer rangeAnswerEntity);

    @Query("SELECT a FROM Answer a JOIN FETCH a.question WHERE a.surveyId = :surveyId")
    List<Answer> findBySurveyId(long surveyId);
}
