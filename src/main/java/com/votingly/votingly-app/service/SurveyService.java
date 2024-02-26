package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.repositories.SurveyJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private final SurveyJpaRepo surveyJpaRepo;

    public SurveyService(SurveyJpaRepo surveyJpaRepo) {
        this.surveyJpaRepo = surveyJpaRepo;
    }

    public List<Survey> getAllSurveys() {
        return surveyJpaRepo.findAll();
    }
}
