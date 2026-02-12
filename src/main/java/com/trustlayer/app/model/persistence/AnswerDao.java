package com.trustlayer.app.model.persistence;

import com.trustlayer.app.model.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao extends JpaRepository<Answer, Long> {

}
