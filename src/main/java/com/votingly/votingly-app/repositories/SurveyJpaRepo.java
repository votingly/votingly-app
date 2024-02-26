package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepo extends JpaRepository<Survey, Integer> {
}
