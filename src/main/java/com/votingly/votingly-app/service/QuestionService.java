package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionsRepository questionsRepository;

    @Autowired
    public QuestionService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
    @Transactional
    public List<Question> getAllQuestions() {
        return questionsRepository.findAllQuestions();
    }
    @Transactional
    public Question getQuestion(long id) {
        return questionsRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Question> findAllQuestionById(long id) {
        return questionsRepository.findAllBySurveyIdFetched(id);
    }
}
