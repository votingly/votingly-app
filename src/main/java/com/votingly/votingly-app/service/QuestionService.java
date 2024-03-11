package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionsRepository questionsRepository;

    @Autowired
    public QuestionService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public List<Question> getAllQuestions() {
        return questionsRepository.findAllQuestions();
    }
}
