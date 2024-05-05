package com.votingly.votingly-app.controller.api.dto.questions;

import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;


public class QuestionDto {
    private long id;

    private String questionName;

    private QuestionType questionType;

    private Survey surveyId;


    public QuestionDto() {
    }

    public QuestionDto(long id, String questionName, QuestionType questionType, Survey surveyId) {
        this.id = id;
        this.questionName = questionName;
        this.questionType = questionType;
        this.surveyId = surveyId;
    }

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.questionName = question.getQuestionName();
        this.questionType = question.getQuestionType();
        this.surveyId = question.getSurvey();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Survey getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Survey surveyId) {
        this.surveyId = surveyId;
    }

}
