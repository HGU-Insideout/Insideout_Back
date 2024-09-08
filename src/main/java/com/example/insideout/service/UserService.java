package com.example.insideout.service;

import com.example.insideout.controller.form.UserForm;
import com.example.insideout.domain.User;
import com.example.insideout.dto.UserDto;
import com.example.insideout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
