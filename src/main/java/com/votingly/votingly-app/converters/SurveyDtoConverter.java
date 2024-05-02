package com.votingly.votingly-app.converters;

import com.votingly.votingly-app.controller.api.dto.SurveyDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurveyDtoConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public SurveyDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SurveyDto convert(Survey survey) {
        List<QuestionDto> questionDtos = survey.getQuestions().stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .toList();
        SurveyDto dto = modelMapper.map(survey, SurveyDto.class);
//        dto.setQuestions(questionDtos);
        return dto;
    }


}
