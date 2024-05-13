package com.votingly.votingly-app.converters;

import com.votingly.votingly-app.controller.api.dto.questions.OptionDto;
import com.votingly.votingly-app.controller.api.dto.questions.ChoiceDto;
import com.votingly.votingly-app.controller.api.dto.questions.QuestionDto;
import com.votingly.votingly-app.controller.api.dto.questions.RangeDto;
import com.votingly.votingly-app.model.question.ChoiceQuestion;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.model.question.QuestionType;
import com.votingly.votingly-app.model.question.RangeQuestion;

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

    // public Question convertFromDto(QuestionDto dto) {
    //     Question question = new Question(dto.getQuestionId(), dto.getQuestionName(), dto.getQuestionType());
    //     question.setSurveyId(dto.getSurveyId());

    // }

    private ChoiceDto convertChoiceQuestion(ChoiceQuestion question) {
        ChoiceDto choiceDto = new ChoiceDto(question);
        choiceDto.setOptions(question.getOptions().stream()
                .map(option -> new OptionDto(
                        option.getOptionId(),
                        option.getOptionText()))
                .collect(Collectors.toList()));
        choiceDto.setMultiChoice(question.isMultiChoice());
        return choiceDto;
    }

    private RangeDto convertRangeQuestion(RangeQuestion question) {
        RangeDto rangeDto = new RangeDto(question);
        rangeDto.setMin(question.getMin());
        rangeDto.setMax(question.getMax());
        rangeDto.setStep(question.getStep());
        return rangeDto;
    }
}
