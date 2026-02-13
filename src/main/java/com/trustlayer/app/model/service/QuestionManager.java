package com.trustlayer.app.model.service;


import com.trustlayer.app.model.entities.Answer;
import com.trustlayer.app.model.entities.Question;
import com.trustlayer.app.model.persistence.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionManager {
    @Autowired
    private QuestionDao questionDao;

    public void saveQuestion(Question question) {
        if (question.getQuestion() == null || question.getQuestion().isBlank()) {
            throw new IllegalArgumentException("Question text cannot be null or empty");
        }
        question.setQuestion(question.getQuestion().trim());
        questionDao.save(question);
    }

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
}
