package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

    @Query("SELECT options FROM Option options")
    List<Option> findAllOptions();

    List<Option> findAllByQuestionId(long questionId);

}