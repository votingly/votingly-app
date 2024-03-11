package com.votingly.votingly-app.model.question;

import com.votingly.votingly-app.model.QuestionType;

public class OpenQuestion extends Question {
    public OpenQuestion() {
    }

    public OpenQuestion(long id, String questionName, QuestionType questionType) {
        super(id, questionName, questionType);
    }
}
