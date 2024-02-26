package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormJpaRepo extends JpaRepository<Form, Integer> {
}
