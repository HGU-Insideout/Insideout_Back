package com.example.insideout.controller;

import com.example.insideout.controller.form.UserDetailForm;
import com.example.insideout.controller.form.UserForm;
import com.example.insideout.controller.response.ApiResponse;
import com.example.insideout.controller.response.UserIdResponse;
import com.example.insideout.controller.response.UserListResponse;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.dto.UserDto;
import com.example.insideout.service.UserDetailService;
import com.example.insideout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userDetail")
public class UserDetailController {

    private final UserDetailService userDetailService;
    private final UserService userService;

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDetail> getUserDetail(@PathVariable Long userId) {
        UserDetail userDetail = userDetailService.getUserDetail(userId);  // User의 ID로 UserDetail 조회
        return ResponseEntity.ok(userDetail);  // UserDetail 반환
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<ApiResponse> createUserDetail(@PathVariable Long userId, @RequestBody UserDetailForm userDetailForm) {
        User user = userService.findUserById(userId);
        Long userDetailId = userDetailService.createUserDetail(UserDetailDto.from(userDetailForm), user);

        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<ApiResponse> updateUserDetail(@PathVariable Long userId, @RequestBody UserDetailForm userDetailForm) {
        userDetailService.updateUserDetail(userId, UserDetailDto.from(userDetailForm));
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUserDetail(@PathVariable Long userId) {
        userDetailService.deleteUserDetail(userId);
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }



}
