package com.trustlayer.app.model.persistence;

import com.trustlayer.app.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

}
