package com.trustlayer.app.model.service;

import com.trustlayer.app.model.entities.Answer;
import com.trustlayer.app.model.persistence.AnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerManager {
    @Autowired
    private  AnswerDao answerDao;

    public void saveAnswer(Answer answer) {
        answerDao.save(answer);
    }

    public List<Answer> getAllAnswers(){
        return answerDao.findAll();
    }
}
