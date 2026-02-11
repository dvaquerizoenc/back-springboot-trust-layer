package com.trustlayer.app.controllers;

import com.trustlayer.app.model.dto.UserResponse;
import com.trustlayer.app.model.entities.User;
import com.trustlayer.app.exceptions.UserException;
import com.trustlayer.app.model.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping(path="api/create/user",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> altaPersona(@RequestBody User u) {
        try {
            UserResponse user = userManager.registerUser(u);
            return new ResponseEntity<UserResponse>(user, HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
