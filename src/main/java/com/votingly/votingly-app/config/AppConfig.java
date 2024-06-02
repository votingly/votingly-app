package com.votingly.votingly-app.config;

import com.votingly.votingly-app.converters.QuestionDtoConverter;
import com.votingly.votingly-app.converters.SurveyDtoConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Apply configuration to the modelMapper instance
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); // Example: Set strict matching strategy
        return modelMapper;
    }

    @Bean
    public QuestionDtoConverter questionDtoConverter() {
        return new QuestionDtoConverter();
    }
}
