package com.example.insideout.service;

import com.example.insideout.domain.UserDetail;
import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;


    public UserDetailDto findUserDetailByUserId(Long userId) {
        UserDetail userDetail = userDetailRepository.findByUserId(userId);
        return convertToDto(userDetail); // 엔티티 -> DTO 변환
    }


    public UserDetailDto saveUserDetail(UserDetail userDetailDto) {
        UserDetail userDetail = convertToEntity(userDetailDto); // DTO -> 엔티티 변환
        UserDetail savedDetail = userDetailRepository.save(userDetail);
        return convertToDto(savedDetail); // 저장된 후 DTO로 반환
    }


    public UserDetailDto updateUserDetail(Long id, UserDetail userDetailDto) {
        UserDetail userDetail = userDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDetail not found"));
        userDetail.setType(userDetailDto.getType());
        userDetail.setCenter(userDetailDto.getCenter());
        UserDetail updatedDetail = userDetailRepository.save(userDetail);
        return convertToDto(updatedDetail); // 업데이트 후 DTO로 반환
    }


    public void deleteUserDetail(Long id) {
        userDetailRepository.deleteById(id);
    }


    private UserDetailDto convertToDto(UserDetail userDetail) {
        UserDetailDto dto = new UserDetailDto();
        dto.setId(userDetail.getUserDetailId());
        return dto;
    }


    private UserDetail convertToEntity(UserDetail userDetailDto) {
        UserDetail userDetail = new UserDetail();
        userDetail.setType(userDetailDto.getType());
        return userDetail;
    }

}
