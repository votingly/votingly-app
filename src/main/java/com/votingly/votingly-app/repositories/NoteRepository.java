package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.Note;
import com.votingly.votingly-app.model.Option;
import com.votingly.votingly-app.model.Survey;
import com.votingly.votingly-app.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}