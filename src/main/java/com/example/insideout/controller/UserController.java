package com.example.insideout.controller;

import com.example.insideout.controller.form.UserForm;
import com.example.insideout.controller.response.ApiResponse;
import com.example.insideout.controller.response.UserIdResponse;
import com.example.insideout.domain.User;
import com.example.insideout.dto.UserDto;
import com.example.insideout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserForm userForm) {
        System.out.println("createUser");
        Long userId = userService.createUser(UserDto.from(userForm));
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
