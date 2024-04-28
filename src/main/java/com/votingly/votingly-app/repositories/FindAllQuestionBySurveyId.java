package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Question;

import java.util.List;

public interface FindAllQuestionBySurveyId {
    List<Question> findAllBySurveyIdFetched(Long id);
}
