package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Note;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.SurveyType;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.repositories.NoteRepository;
import com.votingly.votingly-app.repositories.QuestionsRepository;
import com.votingly.votingly-app.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final QuestionsRepository questionsRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository, QuestionsRepository questionsRepository, NoteRepository noteRepository) {
        this.surveyRepository = surveyRepository;
        this.questionsRepository = questionsRepository;
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

    public void addSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    public void delete(long id) {
        surveyRepository.deleteById(id);
    }

    public boolean changeSurveyInfo(long surveyId, String newSurveyName, SurveyType newSurveyType, List<Question> newListQuestions) {
        var surveyPresent = surveyRepository.findById(surveyId).orElse(null);
        if (surveyPresent == null) {
            return false;
        }

        surveyPresent.setSurveyName(newSurveyName);
        surveyPresent.setSurveyType(newSurveyType);

        List<Question> updatedQuestions = new ArrayList<>();
        for (Question newQuestion : newListQuestions) {
            Question existingQuestion = questionsRepository.findQuestionById(newQuestion.getId());
            if (existingQuestion != null) {
                existingQuestion.setQuestionName(newQuestion.getQuestionName());
                updatedQuestions.add(existingQuestion);
            } else {
                updatedQuestions.add(newQuestion);
            }
        }

        surveyPresent.setQuestions(updatedQuestions);
        surveyRepository.save(surveyPresent);
        return true;
    }


    public void addNoteToSurvey(Long id, String content) {
        Note note = new Note();
        Survey survey = surveyRepository.findBySurveyId(id);
        note.setSurvey(survey);
        note.setContent(content);
        noteRepository.save(note);
    }

}
