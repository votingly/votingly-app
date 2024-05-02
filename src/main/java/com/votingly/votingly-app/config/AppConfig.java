package com.votingly.votingly-app.config;

import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.converters.SurveyDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
    @Bean
    public QuestionDtoConverter questionDtoConverter() {
        return new QuestionDtoConverter();
    }
//    @Bean
//    public SurveyDtoConverter surveyDtoConverter() {
//        return new SurveyDtoConverter();
//    }
}
