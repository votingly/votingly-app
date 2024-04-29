package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.repositories.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Option> getOptionsByQuestionId(long questionId) {
        return optionRepository.findAllByQuestionId(questionId);
    }
}
