package com.example.insideout.service;

import com.example.insideout.controller.response.UserListResponse;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.dto.UserDto;
import com.example.insideout.repository.UserDetailRepository;
import com.example.insideout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Long createUser(UserDto userDto) {
        User user = userRepository.save(User.toUser(userDto));
        return user.getId();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // updageUSer

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public void updateUser(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.update(userDto);
        userRepository.save(user);

    }


    public UserDto detailUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.from(user);
    }

    public UserListResponse getUserList() {
        List<User> user = userRepository.findAll();
        return new UserListResponse(user);
    }

    private final UserDetailRepository userDetailRepository;




}
