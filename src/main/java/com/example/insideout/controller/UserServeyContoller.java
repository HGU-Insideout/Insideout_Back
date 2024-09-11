package com.example.insideout.controller;

import com.example.insideout.controller.form.UserDetailForm;
import com.example.insideout.controller.form.UserServeyForm;
import com.example.insideout.controller.response.ApiResponse;
import com.example.insideout.controller.response.UserIdResponse;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.domain.UserServey;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.dto.UserServeyDto;
import com.example.insideout.service.UserDetailService;
import com.example.insideout.service.UserServeyService;
import com.example.insideout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userServey")
public class UserServeyContoller {


    private final UserServeyService userServeyService;
    private final UserService userService;

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserServey> getUserServey(@PathVariable Long userId) {
        UserServey userServey = userServeyService.getUserServey(userId);
        return ResponseEntity.ok(userServey);
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<ApiResponse> createUserServey(@PathVariable Long userId, @RequestBody UserServeyForm userServeyForm) {
        User user = userService.findUserById(userId);
        Long userServeyId = userServeyService.createUserServey(UserServeyDto.from(userServeyForm), user);
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<ApiResponse> updateUserServey(@PathVariable Long userId, @RequestBody UserServeyForm userServeyForm) {
        userServeyService.updateUserServey(userId, UserServeyDto.from(userServeyForm));
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUserServey(@PathVariable Long userId) {
        userServeyService.deleteUserServey(userId);
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

}
