package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.ChoiceQuestion;
import com.votingly.votingly-app.model.question.OpenQuestion;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;
import com.votingly.votingly-app.model.question.RangeQuestion;
import com.votingly.votingly-app.repositories.OptionRepository;
import com.votingly.votingly-app.repositories.QuestionsRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionService {
    private final QuestionsRepository questionsRepository;
    private final OptionRepository optionRepository;
    private final OptionService optionService;
    private final Logger logger;

    @Autowired
    public QuestionService(QuestionsRepository questionsRepository, OptionRepository optionRepository, OptionService optionService, Logger logger) {
        this.questionsRepository = questionsRepository;
        this.optionRepository = optionRepository;
        this.optionService = optionService;
        this.logger = logger;
    }

    public List<Question> getAllQuestions() {
        return questionsRepository.findAllQuestions();
    }

    public Question getQuestion(long id) {
        return questionsRepository.findById(id).orElse(null);
    }

    public List<Question> findAllQuestionById(long id) {
        return questionsRepository.findAllBySurveyIdFetched(id);
    }

    public void addQuestions(List<Question> questions) {
        for (Question question : questions) {
            if (question.getQuestionType() == QuestionType.CHOICE) {
                ChoiceQuestion choiceQuestion = (ChoiceQuestion) question;
                questionsRepository.save(choiceQuestion);
                optionService.addOptions(choiceQuestion.getOptions());
            } else {
                questionsRepository.save(question);
            }
        }
    }
    
    public void addQuestion(Question question) {
        questionsRepository.save(question);
    }

    public List<Question> getQuestionsBySurvey(Survey survey) {
        return questionsRepository.getQuestionsBySurvey(survey);
    }


    public void deleteQuestionsBySurvey(Survey survey) {
        List<Question> questions = questionsRepository.getQuestionsBySurvey(survey);
        for (Question question : questions) {
            if (question.getClass().equals(ChoiceQuestion.class)) {
                optionRepository.deleteByQuestion(question);
            }
            questionsRepository.delete(question);
        }
    }

}
