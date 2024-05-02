package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.answers.Answer;
import com.votingly.votingly-app.model.answers.ChoiceAnswer;
import com.votingly.votingly-app.model.answers.OpenAnswer;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.answers.RangeAnswer;
import com.votingly.votingly-app.repositories.AnswerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer saveOpen(long surveyId, long userId, Question question, String answer) {
        var openAnswerEntity = new OpenAnswer(surveyId, userId, question, answer);

        return answerRepository.save(openAnswerEntity);
    }

    public Answer saveRange(long surveyId, long userId, Question question, int number) {
        var rangeAnswerEntity = new RangeAnswer(surveyId, userId, question, number);

        return answerRepository.save(rangeAnswerEntity);
    }

    public Answer saveChoice(long surveyId, long userId, Question question, List<Option> options) {
        var choiceAnswerEntity = new ChoiceAnswer(surveyId, userId, question, options);

        return answerRepository.save(choiceAnswerEntity);
    }

}
