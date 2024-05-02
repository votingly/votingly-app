package com.votingly.votingly-app.model.answers;

import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.question.Question;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceAnswer extends Answer {

    @OneToMany(mappedBy = "answer")
    private List<Option> options;

    public ChoiceAnswer() {
    }

    public ChoiceAnswer(List<Option> options) {
        this.options = options;
    }

    public ChoiceAnswer(long surveyId, long userId, Question question, List<Option> options) {
        super(surveyId, userId, question);
        this.options = options;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
