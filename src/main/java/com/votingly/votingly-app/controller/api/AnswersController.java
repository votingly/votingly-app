package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.model.Answer;
import com.votingly.votingly-app.model.OpenAnswer;
import com.votingly.votingly-app.model.QuestionType;
import com.votingly.votingly-app.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
public class AnswersController {
    private final AnswerService answerService;

    @Autowired
    public AnswersController(AnswerService answerService) {
        this.answerService = answerService;
    }

    // @PostMapping
    // private ResponseEntity<Answer> saveAnswerForQuestion(@RequestParam("answerId") answerId,
    //                                                      @RequestBody Answer answer) {
    //     Answer savedAnswer = answerService.save(answer);
    //     return ResponseEntity.ok(savedAnswer);
    // }
}
