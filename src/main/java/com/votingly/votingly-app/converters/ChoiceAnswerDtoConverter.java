package com.votingly.votingly-app.converters;

import com.votingly.votingly-app.controller.api.dto.answer.AnswerDto;
//import com.votingly.votingly-app.controller.api.dto.answer.ChoiceDto;
import com.votingly.votingly-app.controller.api.dto.answer.ChoiceDto;
import com.votingly.votingly-app.controller.api.dto.questions.OptionDto;
import com.votingly.votingly-app.model.answers.Answer;
import com.votingly.votingly-app.model.answers.ChoiceAnswer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChoiceAnswerDtoConverter {
    public AnswerDto convert(Answer answer) {

        AnswerDto dto;
        dto = new AnswerDto(answer.getAnswerId(), answer.getSurveyId(), answer.getUserId(), answer.getQuestion());

        if (answer instanceof ChoiceAnswer) {
            dto = convertChoiceAnswer((ChoiceAnswer) answer);
        }
        return dto;
    }

    private ChoiceDto convertChoiceAnswer(ChoiceAnswer answer) {
        ChoiceDto choiceDto = new ChoiceDto(answer);
        choiceDto.setOptions_answer(answer.getOptions_answer().stream()
                .map(option -> new OptionDto(
                        option.getOptionId(),
                        option.getOptionText()))
                .collect(Collectors.toList()));
        return choiceDto;
    }
}
