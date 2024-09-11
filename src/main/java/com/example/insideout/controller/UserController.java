package com.example.insideout.controller;

import com.example.insideout.controller.form.UserForm;
import com.example.insideout.controller.response.ApiResponse;
import com.example.insideout.controller.response.UserIdResponse;
import com.example.insideout.controller.response.UserListResponse;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
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
        Long userId = userService.createUser(UserDto.from(userForm)); //UserForm 객체를 UserDto로 변환
        ApiResponse response = new UserIdResponse(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ApiResponse response = new UserIdResponse(id);
        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long id, @RequestBody UserForm userForm) {
       userService.updateUser(id, UserDto.from(userForm));
       ApiResponse response = new UserIdResponse(id);
       return ResponseEntity.ok(response);
    }
//
//    @GetMapping("/detail/{id}")
//    public ResponseEntity<ApiResponse> detailUser(@PathVariable Long id){
//        UserDto userdto = userService.detailUser(id);
//        ApiResponse response = new UserIdResponse(id);
//        System.out.println(userdto);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("")
    public ResponseEntity<UserListResponse> getUserList() {
        UserListResponse userListResponse = userService.getUserList();
        return ResponseEntity.ok(userListResponse);
    }



}
