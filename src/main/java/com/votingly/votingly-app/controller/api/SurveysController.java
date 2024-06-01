package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.controller.api.dto.SurveyDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.converters.SurveyDtoConverter;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;
import com.votingly.votingly-app.service.QuestionService;
import com.votingly.votingly-app.service.SurveyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveysController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ModelMapper modelMapper;
    private final QuestionDtoConverter questionDtoConverter;
    private final SurveyDtoConverter surveyDtoConverter;

    @Autowired
    public SurveysController(SurveyService surveyService, QuestionService questionService, ModelMapper modelMapper, QuestionDtoConverter questionDtoConverter, SurveyDtoConverter surveyDtoConverter) {
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.modelMapper = modelMapper;
        this.questionDtoConverter = questionDtoConverter;
        this.surveyDtoConverter = surveyDtoConverter;
    }

    @GetMapping
    List<SurveyDto> getAllSurveys() {
        return surveyService.getAllSurveys()
                .stream()
                .map(surveyDtoConverter::convertToDto).toList();
    }


    @GetMapping("/{id}/questions")
    ResponseEntity<List<QuestionDto>> getQuestionsOfSurvey(@PathVariable("id") long surveyId) {
        List<Question> questions = questionService.findAllQuestionById(surveyId);
        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<QuestionDto> questionDtos = questions.stream()
                .map(questionDtoConverter::convert)
                .toList();

        return ResponseEntity.ok(questionDtos);
    }

    @PostMapping
    public ResponseEntity<SurveyDto> addSurvey(
            @RequestBody SurveyDto surveyDto
    ) {
        Survey survey = modelMapper.map(surveyDto, Survey.class);
        List<Question> questions = new ArrayList<>();
        for (QuestionDto questionDto : surveyDto.getQuestions()) {
            Question question = new Question(
                    questionDto.getQuestionName(),
                    questionDto.getQuestionType()
            );

            // Infer isMultiChoice based on questionType
            boolean isMultiChoice = question.getQuestionType() == QuestionType.CHOICE;

            questions.add(question);
        }
        surveyService.addSurvey(survey);
        questions.forEach(question -> question.setSurvey(survey));
        questionService.addQuestions(questions);

        return ResponseEntity.status(HttpStatus.CREATED).body(surveyDto);
    }


    @GetMapping("/{id}/details")
    public ResponseEntity<SurveyDto> getSurveyDetails(@PathVariable("id") long id) {
        Survey survey = surveyService.getSurvey(id);
        List<Question> questions = questionService.getQuestionsBySurvey(survey);
        List<QuestionDto> questionDtos = questions.stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .toList();
//        survey.setQuestions(questions);
        SurveyDto surveyDto = new SurveyDto(
                survey.getSurveyName(),
                survey.getSurveyType(),
                questionDtos
        );
        return ResponseEntity.ok(surveyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(
            @PathVariable("id") final long id
    ) {
        Survey survey = surveyService.getSurvey(id);
        questionService.deleteQuestionsBySurvey(survey);
        surveyService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
