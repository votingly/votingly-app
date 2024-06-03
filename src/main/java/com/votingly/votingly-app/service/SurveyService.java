package com.votingly.votingly-app.service;

import com.votingly.votingly-app.controller.api.dto.UpdatedSurveyDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDtoIn;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.SurveyType;
import com.votingly.votingly-app.model.question.ChoiceQuestion;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;
import com.votingly.votingly-app.repositories.FindAllQuestionBySurveyId;
import com.votingly.votingly-app.repositories.SurveyRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurvey(long surveyId) {
        return surveyRepository.findBySurveyId(surveyId);
    }

    @Transactional
    public List<Long> getQuestionsOfSurvey(long id) {
        return surveyRepository.getQuestionIdsBySurveyId(id);
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void addSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    public void delete(long id) {
        surveyRepository.deleteById(id);
    }

    public boolean changeSurveyInfo(long surveyid, String name, SurveyType type) {
        var survey = surveyRepository.findById(surveyid).orElse(null);
        if (survey == null) {
            return false;
        }
        survey.setSurveyName(name);
        survey.setSurveyType(type);

        surveyRepository.save(survey);
        return true;
    }
}
