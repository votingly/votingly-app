package com.votingly.votingly-app.converters;

import com.votingly.votingly-app.controller.api.dto.OptionDto;
import com.votingly.votingly-app.controller.api.dto.questions.ChoiceDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.controller.api.dto.questions.RangeDto;
import com.votingly.votingly-app.model.ChoiceQuestion;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.Question;
import com.votingly.votingly-app.model.RangeQuestion;

import java.util.stream.Collectors;

public class QuestionDtoConverter {

    public QuestionDto convert(Question question) {

        QuestionDto dto;
        dto = new QuestionDto(question.getId(), question.getQuestionName(), question.getQuestionType(), question.getSurvey().getSurveyId());

        if (question instanceof ChoiceQuestion) {
            dto = convertChoiceQuestion((ChoiceQuestion) question);
        } else if (question instanceof RangeQuestion) {
            dto = convertRangeQuestion((RangeQuestion) question);
        }

        return dto;
    }

    private QuestionDto convertChoiceQuestion(ChoiceQuestion question) {
        ChoiceDto choiceDto = new ChoiceDto();
        choiceDto.setOptions(question.getOptions().stream()
                .map(option -> new OptionDto())
                .collect(Collectors.toList()));
        choiceDto.setMultiChoice(question.isMultiChoice());
        return choiceDto;
    }

    private QuestionDto convertRangeQuestion(RangeQuestion question) {
        RangeDto rangeDto = new RangeDto(question);
        rangeDto.setMin(question.getMin());
        rangeDto.setMax(question.getMax());
        rangeDto.setStep(question.getStep());
        return rangeDto;
    }
}
