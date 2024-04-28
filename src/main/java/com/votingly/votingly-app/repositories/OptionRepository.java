package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.ChoiceQuestion;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
//    @Query("""
//            select choiceQuestion from ChoiceQuestion choiceQuestion
//            left join fetch choiceQuestion.options options
//             where choiceQuestion.options = :choice
//             """)
//    Optional<Survey> getOptionsOfChoiceQuestion(long choiceQuestionId);

    List<Option> getOptionByQuestionId(long question_id);
}
