package com.augustine.musalasoftdroneservice.service;

import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 12:43 PM
 * @project MusalaSoftDroneService
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity addUser(User user) {

        if (repository.findByName(user.getName()) != null) {
            return new ResponseEntity("User already exists", HttpStatus.BAD_REQUEST);
        }
        User newUser = repository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }
}
