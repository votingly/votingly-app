package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.controller.api.dto.SurveyDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.converters.SurveyDtoConverter;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.service.QuestionService;
import com.votingly.votingly-app.service.SurveyService;
import org.modelmapper.ModelMapper;
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
                .map(survey -> modelMapper.map(survey, SurveyDto.class)).toList();
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

    @PostMapping("/create")
    public ResponseEntity<SurveyDto> createSurvey(@RequestBody SurveyDto surveyDto) {
        // Survey survey = modelMapper.map(surveyDto, Survey.class);
        Survey survey = surveyDtoConverter.convertFromDto(surveyDto);
        Survey createdSurvey = surveyService.createSurvey(survey);
        SurveyDto createdSurveyDto = modelMapper.map(createdSurvey, SurveyDto.class);
        List<Question> questions = surveyDto.getQuestions();
        for (Question question : questions) {
            question.setSurvey(createdSurvey);
            // questionService.createQuestion(question);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSurveyDto);
    }
}
