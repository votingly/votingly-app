package com.votingly.votingly-app.service;

import com.votingly.votingly-app.controller.api.dto.UpdatedSurveyDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDtoIn;
import com.votingly.votingly-app.model.Note;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.controller.api.dto.questions.UpdateQuestionDto;
import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.SurveyType;
import com.votingly.votingly-app.model.question.ChoiceQuestion;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;
import com.votingly.votingly-app.repositories.FindAllQuestionBySurveyId;
import com.votingly.votingly-app.repositories.NoteRepository;
import com.votingly.votingly-app.repositories.SurveyRepository;
import org.modelmapper.ModelMapper;
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
    private final NoteRepository noteRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository, NoteRepository noteRepository) {
        this.surveyRepository = surveyRepository;
        this.noteRepository = noteRepository;
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

    public Survey changeSurveyInfo(long surveyid, Survey survey) {
        var surveyPresent = surveyRepository.findById(surveyid).orElse(null);
        if (surveyPresent == null) {
            return null;
        }
        surveyPresent.setSurveyName(survey.getSurveyName());
        surveyPresent.setSurveyType(survey.getSurveyType());

        surveyRepository.save(surveyPresent);
        return surveyPresent;
    }

    public void addNoteToSurvey(Long id, String content) {
        Note note = new Note();
        Survey survey = surveyRepository.findBySurveyId(id);
        note.setSurvey(survey);
        note.setContent(content);
        noteRepository.save(note);
    }
}
