package com.example.insideout.service;

import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.domain.UserServey;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.dto.UserServeyDto;
import com.example.insideout.repository.UserDetailRepository;
import com.example.insideout.repository.UserServeyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServeyService {
    private final UserServeyRepository userServeyRepository;

    public UserServeyService(UserServeyRepository userServeyRepository) {
        this.userServeyRepository = userServeyRepository;
    }

    public UserServey getUserServey(Long userId) {
        return userServeyRepository.findByUser_Id(userId);  // userId를 이용하여 UserDetail을 조회
    }

    public Long createUserServey(UserServeyDto userServeyDto, User user) {
        UserServey userServey = userServeyRepository.save(UserServey.toUserServey(userServeyDto, user));
        return userServey.getUserServeyId();
    }

    public void updateUserServey(Long userId, UserServeyDto userServeyDto){
        UserServey userServey = userServeyRepository.findByUser_Id(userId);

        userServey.setDepression(userServeyDto.getDepression());
        userServey.setMentalIllness(userServeyDto.getMentalIllness());
        userServey.setAlcohol(userServeyDto.getAlcohol());
        userServey.setStress(userServeyDto.getStress());
        userServey.setMentalIndex(userServeyDto.getMentalIndex());

        userServeyRepository.save(userServey);

    }

    public void deleteUserServey(Long userId) {
        UserServey userServey = userServeyRepository.findByUser_Id(userId);
        userServeyRepository.delete(userServey);
    }

}
