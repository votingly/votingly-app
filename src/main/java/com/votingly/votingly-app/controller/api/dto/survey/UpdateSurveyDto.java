package com.votingly.votingly-app.controller.api.dto.survey;

import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.model.SurveyType;

import java.util.List;

public class UpdateSurveyDto {
    private String surveyName;
    private SurveyType surveyType;
    private List<QuestionDto> questions;

    public UpdateSurveyDto(String surveyName, SurveyType surveyType, List<QuestionDto> questions) {
        this.surveyName = surveyName;
        this.surveyType = surveyType;
        this.questions = questions;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public SurveyType getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(SurveyType surveyType) {
        this.surveyType = surveyType;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
