package com.example.insideout.controller;

import com.example.insideout.domain.UserServey;
import com.example.insideout.service.UserServeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surveys")
public class UserServeyController {


    @Autowired
    private UserServeyService userServeyService;

    @GetMapping("/{userId}")
    public UserServey getUserServeyByUserId(@PathVariable Long userId) {
        return userServeyService.findUserServeyByUserId(userId);
    }


    @PostMapping
    public UserServey createUserServey(@RequestBody UserServey userServey) {
        return userServeyService.saveUserServey(userServey);
    }


    @PutMapping("/{id}")
    public UserServey updateUserServey(@PathVariable Long id, @RequestBody UserServey userServeyDetails) {
        return userServeyService.updateUserServey(id, userServeyDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserServey(@PathVariable Long id) {
        userServeyService.deleteUserServey(id);
        return ResponseEntity.ok().build();
    }
}
