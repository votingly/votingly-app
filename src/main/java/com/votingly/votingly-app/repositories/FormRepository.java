package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.controller.api.dto.QuestionDto;
import com.votingly.votingly-app.model.Form;
import com.votingly.votingly-app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Integer> {
    Form findById(long formId);

    @Query("""
            select form from Form form
            left join fetch form.questions questions
            left join fetch questions.form
            where form.id = :formId
            """)
    Optional<Form> getQuestionOfForm(long formId);
}
