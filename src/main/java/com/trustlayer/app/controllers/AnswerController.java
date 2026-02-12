package com.trustlayer.app.controllers;

import com.trustlayer.app.model.entities.Answer;
import com.trustlayer.app.model.service.AnswerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerManager answerManager;

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public void saveAnswer(@RequestBody Answer answer){
        answerManager.saveAnswer(answer);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Answer> getAllAnswers(){
        return answerManager.getAllAnswers();
    }
}
