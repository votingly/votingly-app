package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.controller.api.dto.AnswerDto;
import com.votingly.votingly-app.controller.api.dto.NewOpenAnswer;
import org.modelmapper.ModelMapper;
import com.votingly.votingly-app.model.Answer;
import com.votingly.votingly-app.model.OpenAnswer;
import com.votingly.votingly-app.model.Question;
import com.votingly.votingly-app.model.QuestionType;
import com.votingly.votingly-app.service.AnswerService;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
public class AnswersController {
    private final AnswerService answerService;
    private final ModelMapper modelMapper;

    @Autowired
    public AnswersController(AnswerService answerService, ModelMapper modelMapper) {
        this.answerService = answerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/open/{questionId}")
    public ResponseEntity<AnswerDto> saveAnswerForQuestion(
            @RequestBody @Valid NewOpenAnswer newOpenAnswer,
            @PathVariable long questionId) {

//        if (openAnswer != null) {
        var newAnswer = answerService.save(
                newOpenAnswer.getAnswer()
        );
        return new ResponseEntity<>(
                modelMapper.map(newAnswer, AnswerDto.class),
                HttpStatus.CREATED
        );
//        }

    }
}
//            openAnswer.setQuestion(questionId);
//
//            OpenAnswer savedAnswer = answerService.save(
//                    openAnswer.getUserId(),
//                    openAnswer.getSurveyId(),
//                    openAnswer.getQuestion(),
//                    openAnswer.getAnswer()
//            );
//            return ResponseEntity.ok(savedAnswer);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }