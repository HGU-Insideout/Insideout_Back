package com.example.insideout.service;

import com.example.insideout.domain.UserServey;
import com.example.insideout.repository.UserServeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServeyService {


    @Autowired
    private UserServeyRepository userServeyRepository;


    public UserServey findUserServeyByUserId(Long userId) {
        return userServeyRepository.findByUserId(userId);
    }


    public UserServey saveUserServey(UserServey userServey) {
        return userServeyRepository.save(userServey);
    }


    public UserServey updateUserServey(Long id, UserServey userServeyDetails) {
        UserServey userServey = userServeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserServey not found"));
        userServey.setDepression(userServeyDetails.getDepression());
        userServey.setStress(userServeyDetails.getStress());
        return userServeyRepository.save(userServey);
    }


    public void deleteUserServey(Long id) {
        userServeyRepository.deleteById(id);
    }
}
