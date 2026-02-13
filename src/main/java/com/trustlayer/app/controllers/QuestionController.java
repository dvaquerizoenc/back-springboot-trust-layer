package com.trustlayer.app.controllers;

import com.trustlayer.app.model.entities.Answer;
import com.trustlayer.app.model.entities.Question;
import com.trustlayer.app.model.service.AnswerManager;
import com.trustlayer.app.model.service.QuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionManager questionManager;

    @PostMapping(path="api/questions", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAnswer(@RequestBody Question question){
        try {
            questionManager.saveQuestion(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path="api/questions", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getAllQuestions(){
        return questionManager.getAllQuestions();
    }
}
