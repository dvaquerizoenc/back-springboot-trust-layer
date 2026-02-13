package com.trustlayer.app.controllers;

import com.trustlayer.app.model.entities.Answer;
import com.trustlayer.app.model.entities.Group;
import com.trustlayer.app.model.service.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GroupController {
    @Autowired
    private GroupManager groupManager;

    @PostMapping(path="api/groups", produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveGroup(@RequestBody Group group){
        try {
            groupManager.saveGroup(group);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
