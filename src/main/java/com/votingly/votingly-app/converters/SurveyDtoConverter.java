package com.votingly.votingly-app.converters;

import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.controller.api.dto.survey.SurveyDto;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.ChoiceQuestion;
import com.votingly.votingly-app.model.question.RangeQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurveyDtoConverter {


    public Survey convertFromDto(SurveyDto surveyDto) {
        return new Survey(surveyDto.getSurveyId(), surveyDto.getSurveyName(), surveyDto.getSurveyType(), surveyDto.getStartDate(), surveyDto.getEndDate());
    }

    public SurveyDto convertToDto(Survey survey) {
        return new SurveyDto(survey.getSurveyId(),survey.getSurveyName(),survey.getSurveyType(),survey.getStartDate(),survey.getEndDate());
    }

//public SurveyDto convert(Survey survey) {
//    List<QuestionDto> questionDtos = survey.getQuestions().stream()
//            .map(question -> modelMapper.map(question, QuestionDto.class))
//            .collect(Collectors.toList());
//    SurveyDto dto = new SurveyDto(
//            survey.getSurveyId(),
//            survey.getSurveyName(),
//            survey.getSurveyType(),
//            questionDtos,
//            survey.getStartDate(),
//            survey.getEndDate());
//    return dto;
//}


}
