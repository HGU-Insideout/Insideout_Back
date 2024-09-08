package com.example.insideout.service;

import com.example.insideout.domain.UserServey;
import com.example.insideout.repository.UserServeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServeyService {

    // UserServeyRepository를 주입받아 사용
    @Autowired
    private UserServeyRepository userServeyRepository;

    // 특정 사용자 ID를 기준으로 설문조사 결과 조회
    public UserServey findUserServeyByUserId(Long userId) {
        return userServeyRepository.findByUserId(userId);
    }

    // 새로운 설문조사 결과 저장
    public UserServey saveUserServey(UserServey userServey) {
        return userServeyRepository.save(userServey);
    }

    // 설문조사 결과 업데이트
    public UserServey updateUserServey(Long id, UserServey userServeyDetails) {
        UserServey userServey = userServeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserServey not found"));
        userServey.setDepression(userServeyDetails.getDepression());
        userServey.setStress(userServeyDetails.getStress());
        return userServeyRepository.save(userServey);
    }

    // 설문조사 결과 삭제
    public void deleteUserServey(Long id) {
        userServeyRepository.deleteById(id);
    }
}
