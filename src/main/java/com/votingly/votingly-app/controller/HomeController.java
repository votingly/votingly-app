package com.votingly.votingly-app.controller;

import com.votingly.votingly-app.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomeController {

    private final SurveyService surveyService;

    public HomeController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("surveys", surveyService.getAllSurveys());
        return "index";
    }
}
