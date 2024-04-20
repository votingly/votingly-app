package com.votingly.votingly-app.controller.api.dto;

import com.votingly.votingly-app.model.Question;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewOpenAnswer {
    private long answerId;
    @NotBlank
    private String answer;
    @NotNull
    private long surveyId;
    @NotNull
    private long userId;

    public NewOpenAnswer() {
    }

    public NewOpenAnswer(@NotBlank String answer, @NotNull long surveyId, @NotNull long userId) {
		this.answer = answer;
		this.surveyId = surveyId;
		this.userId = userId;
	}
    
	public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
