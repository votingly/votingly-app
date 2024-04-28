package com.votingly.votingly-app.repositories;

// import com.votingly.votingly-app.controller.api.dto.NewOpenAnswer;
import com.votingly.votingly-app.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
