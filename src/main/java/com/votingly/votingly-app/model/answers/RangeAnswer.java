package com.votingly.votingly-app.model.answers;

import com.votingly.votingly-app.model.question.Question;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalTime;

@Entity
@DiscriminatorValue("RANGE")
public class RangeAnswer extends Answer {

    private int range_answer;

    public RangeAnswer() {

    }

    public RangeAnswer(int range_answer) {
        this.range_answer = range_answer;
    }

    public RangeAnswer(long surveyId, long userId, Question question, int range_answer, LocalTime answerTime) {
        super(surveyId, userId, question, answerTime);
        this.range_answer = range_answer;
    }

    public int getRange_answer() {
        return range_answer;
    }

    public void setRange_answer(int range_answer) {
        this.range_answer = range_answer;
    }
}
