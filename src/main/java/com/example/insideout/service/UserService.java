package com.example.insideout.service;

import com.example.insideout.domain.User;
import com.example.insideout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // UserRepository를 주입받아 사용
    @Autowired
    private UserRepository userRepository;

    // 특정 ID를 가진 사용자 조회
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 새로운 사용자 저장
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 정보 업데이트
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPhone(userDetails.getPhone());
        user.setBirthday(userDetails.getBirthday());
        return userRepository.save(user);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
