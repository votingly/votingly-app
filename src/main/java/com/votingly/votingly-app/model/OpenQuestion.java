package com.votingly.votingly-app.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OPEN")
public class OpenQuestion extends Question {

    public OpenQuestion() {
    }

    public OpenQuestion(long id, String questionName, QuestionType questionType) {
        super(id, questionName, questionType);
    }
}
