package com.votingly.votingly-app.service;

// import com.votingly.votingly-app.controller.api.dto.AnswerDto;
// import com.votingly.votingly-app.controller.api.dto.NewOpenAnswer;
import com.votingly.votingly-app.model.Answer;
import com.votingly.votingly-app.model.OpenAnswer;
import com.votingly.votingly-app.model.Question;
// import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.repositories.AnswerRepository;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.PersistenceContextType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;

    public AnswerService(AnswerRepository answerRepository, ModelMapper modelMapper) {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Answer save(long surveyId, long userId, Question question, String answer) {
        var answerEntity = new OpenAnswer(surveyId, userId, question, answer);

        return answerRepository.save(answerEntity);
    }
}
