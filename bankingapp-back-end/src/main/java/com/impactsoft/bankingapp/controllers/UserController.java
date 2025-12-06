package com.impactsoft.bankingapp.controllers;

import com.impactsoft.bankingapp.entities.User;
import com.impactsoft.bankingapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        List<User> result = userService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable  Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        User user = userService.insert(userToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
