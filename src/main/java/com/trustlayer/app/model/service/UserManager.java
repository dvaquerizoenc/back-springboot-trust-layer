package com.trustlayer.app.model.service;

import com.trustlayer.app.model.dto.UserResponse;
import com.trustlayer.app.model.entities.User;
import com.trustlayer.app.exceptions.UserException;
import com.trustlayer.app.model.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse registerUser(User user) {
        if (userDao.existsByEmail(user.getEmail())) {
            throw new UserException("This email already exists");
        }
        if (userDao.existsByUsername(user.getUsername())) {
            throw new UserException("This username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSaved = userDao.save(user);
        return new UserResponse(userSaved.getId(), userSaved.getEmail(), userSaved.getUsername());
    }

}
