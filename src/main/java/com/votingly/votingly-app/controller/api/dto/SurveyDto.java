package com.votingly.votingly-app.controller.api.dto;

import com.votingly.votingly-app.model.SurveyType;

public class SurveyDto {
    private long surveyId;
    private String surveyName;
    SurveyType surveyType;

    public SurveyDto() {
    }

    public SurveyDto(long surveyId, String surveyName, SurveyType surveyType) {
        this.surveyId = surveyId;
        this.surveyName = surveyName;
        this.surveyType = surveyType;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
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
}
