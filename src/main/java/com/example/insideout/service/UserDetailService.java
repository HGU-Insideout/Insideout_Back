package com.example.insideout.service;

import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.dto.UserDto;
import com.example.insideout.repository.UserDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    public UserDetail getUserDetail(Long userId) {
        return userDetailRepository.findByUser_Id(userId);  // userId를 이용하여 UserDetail을 조회
    }

    public Long createUserDetail(UserDetailDto userDetailDto, User user) {
        UserDetail userDetail = userDetailRepository.save(UserDetail.toUserDetail(userDetailDto, user));
        return userDetail.getUserDetailId();
    }

    public void updateUserDetail(Long userId, UserDetailDto userDetailDto){
        UserDetail userDetail = userDetailRepository.findByUser_Id(userId);

        userDetail.setCenter(userDetailDto.getCenter());
        userDetail.setDisabilityStatus(userDetailDto.getDisabilityStatus());
        userDetail.setInterest(userDetailDto.getInterest());
        userDetail.setEnter(userDetailDto.getEnter());
        userDetail.setType(userDetailDto.getType());

        userDetailRepository.save(userDetail);

    }

    public void deleteUserDetail(Long userId) {
        UserDetail userDetail = userDetailRepository.findByUser_Id(userId);
        userDetailRepository.delete(userDetail);
    }



}
