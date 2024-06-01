package com.votingly.votingly-app.controller.api.dto.answer;

import com.votingly.votingly-app.controller.api.dto.questions.OptionDto;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.answers.ChoiceAnswer;
import com.votingly.votingly-app.model.question.Question;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ChoiceDto extends AnswerDto {

    private List<OptionDto> options_answer;

    public ChoiceDto() {
    }

    public ChoiceDto(ChoiceAnswer choiceAnswer) {
        super(choiceAnswer.getAnswerId(), choiceAnswer.getSurveyId(), choiceAnswer.getUserId(), choiceAnswer.getQuestion());
    }

    public ChoiceDto(long answerId, long surveyId, long userId, Question questionId, String answer, int range_answer, LocalDateTime answerTime, List<OptionDto> options_answer) {
        super(answerId, surveyId, userId, questionId, answer, range_answer, answerTime);
        this.options_answer = options_answer;
    }

    public List<OptionDto> getOptions_answer() {
        return options_answer;
    }

    public void setOptions_answer(List<OptionDto> options_answer) {
        this.options_answer = options_answer;
    }
}
