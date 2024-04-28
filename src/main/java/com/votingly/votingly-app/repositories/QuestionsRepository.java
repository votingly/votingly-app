package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Answer;
import com.votingly.votingly-app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long>, FindAllQuestionBySurveyId {
    @Query("SELECT questions FROM Question questions")
    List<Question> findAllQuestions();

}
