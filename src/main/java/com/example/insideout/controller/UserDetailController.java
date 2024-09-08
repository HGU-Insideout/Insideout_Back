package com.example.insideout.controller;

import com.example.insideout.domain.UserDetail;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userdetails")
public class UserDetailController {


    @Autowired
    private UserDetailService userDetailService;


    @GetMapping("/{userId}")
    public UserDetailDto getUserDetailByUserId(@PathVariable Long userId) {
        return userDetailService.findUserDetailByUserId(userId);
    }


    @PostMapping
    public UserDetailDto createUserDetail(@RequestBody UserDetail userDetail) {
        return userDetailService.saveUserDetail(userDetail);
    }


    @PutMapping("/{id}")
    public UserDetailDto updateUserDetail(@PathVariable Long id, @RequestBody UserDetail userDetailDetails) {
        return userDetailService.updateUserDetail(id, userDetailDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetail(@PathVariable Long id) {
        userDetailService.deleteUserDetail(id);
        return ResponseEntity.ok().build();
    }
}
