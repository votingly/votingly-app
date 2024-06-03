package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.controller.api.dto.survey.SurveyDto;
import com.votingly.votingly-app.controller.api.dto.survey.SurveyDtoIn;
import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.converters.SurveyDtoConverter;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.service.QuestionService;
import com.votingly.votingly-app.service.SurveyService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveysController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ModelMapper modelMapper;
    private final QuestionDtoConverter questionDtoConverter;
    private final SurveyDtoConverter surveyDtoConverter;
    private final Logger logger;

    @Autowired
    public SurveysController(SurveyService surveyService, QuestionService questionService, ModelMapper modelMapper, QuestionDtoConverter questionDtoConverter, SurveyDtoConverter surveyDtoConverter, Logger logger) {
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.modelMapper = modelMapper;
        this.questionDtoConverter = questionDtoConverter;
        this.surveyDtoConverter = surveyDtoConverter;
        this.logger = logger;
    }

    @GetMapping
    List<SurveyDto> getAllSurveys() {
        logger.info("Getting all surveys");
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
    public ResponseEntity<SurveyDtoIn> addSurvey(@RequestBody SurveyDtoIn surveyDto) {
        logger.info(surveyDto.toString());
        Survey survey = modelMapper.map(surveyDto, Survey.class);
        List<Question> questions = surveyDto.getQuestions().stream()
                .map(questionDtoIn -> questionDtoConverter.convertFromDtoIn(questionDtoIn, survey)).toList();

        surveyService.addSurvey(survey);
        questionService.addQuestions(questions);

        return ResponseEntity.status(HttpStatus.CREATED).body(surveyDto);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<SurveyDto> getSurveyDetails(@PathVariable("id") long id) {
        Survey survey = surveyService.getSurvey(id);
        List<Question> questions = questionService.findAllQuestionById(id);
        List<QuestionDto> questionDtos = questions.stream()
                .map(questionDtoConverter::convert)
                .toList();

        SurveyDto surveyDto = new SurveyDto(
                survey.getSurveyId(),
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
