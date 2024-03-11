package com.votingly.votingly-app.controller.api;

import com.votingly.votingly-app.controller.api.dto.FormDto;
import com.votingly.votingly-app.controller.api.dto.QuestionDto;
import com.votingly.votingly-app.model.Form;
import com.votingly.votingly-app.model.question.Question;
import com.votingly.votingly-app.service.FormService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/forms")
public class FormsController {
    private FormService formService;
    private ModelMapper modelMapper;

    @Autowired
    public FormsController(FormService formService, ModelMapper modelMapper) {
        this.formService = formService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    List<FormDto> getAllForms() {
        return formService.getAllForms()
                .stream()
                .map(formDto -> modelMapper.map(formDto, FormDto.class)).toList();
    }


    @GetMapping("/{id}/questions")
    ResponseEntity<List<QuestionDto>> getQuestionsOfForm(@PathVariable("id") long formId) {
        Optional<Form> optionalForm = Optional.ofNullable(formService.getQuestionOfForm(formId));
        if (optionalForm.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Form form = optionalForm.get();

        List<QuestionDto> questionDtos = form.getQuestions()
                .stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .toList();

        return ResponseEntity.ok(questionDtos);
    }
}
