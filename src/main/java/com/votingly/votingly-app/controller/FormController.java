package com.votingly.votingly-app.controller;

import com.votingly.votingly-app.service.FormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("surveys", formService.getAllForms());
        return "index";
    }
}
