package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.controller.api.dto.QuestionDto;
import com.votingly.votingly-app.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormJpaRepo extends JpaRepository<Form, Integer> {
    Form findById(long formId);

    @Query("""
            select form from Form form
            left join fetch form.questionSet questions
            left join fetch form.questionSet
            where form.id = :formId
            """)
    List<QuestionDto> getQuestionsOfForm(long formId);
}
