package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Answer;
import com.votingly.votingly-app.model.OpenAnswer;
import com.votingly.votingly-app.model.Question;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public OpenAnswer save(long answerId,long surveyId, long questionId, long userId, String answer) {
        var answerEntity = new OpenAnswer(answerId, surveyId, questionId, userId, answer);
        return (OpenAnswer) answerRepository.save(answerEntity);
    }
}
