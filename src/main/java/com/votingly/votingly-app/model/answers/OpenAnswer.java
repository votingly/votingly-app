package com.votingly.votingly-app.model.answers;

import com.votingly.votingly-app.model.question.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("OPEN")
public class OpenAnswer extends Answer {
    private String answer;

    public OpenAnswer() {
    }

    public OpenAnswer(String answer) {
        this.answer = answer;
    }


    public OpenAnswer(long surveyId, long userId, Question question, String answer) {
        super(surveyId, userId, question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
