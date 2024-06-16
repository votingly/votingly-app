package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.answers.Answer;

import java.util.List;

public interface FindAllAnswersBySurveyId {
    List<Answer> findAllBySurveyIds(Long surveyId);
}
