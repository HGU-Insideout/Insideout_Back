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

    // 특정 사용자 ID를 기준으로 상세 정보 조회
    public UserDetailDto findUserDetailByUserId(Long userId) {
        UserDetail userDetail = userDetailRepository.findByUserId(userId);
        return convertToDto(userDetail); // 엔티티 -> DTO 변환
    }

    // 새로운 사용자 상세 정보 저장
    public UserDetailDto saveUserDetail(UserDetail userDetailDto) {
        UserDetail userDetail = convertToEntity(userDetailDto); // DTO -> 엔티티 변환
        UserDetail savedDetail = userDetailRepository.save(userDetail);
        return convertToDto(savedDetail); // 저장된 후 DTO로 반환
    }

    // 사용자 상세 정보 업데이트
    public UserDetailDto updateUserDetail(Long id, UserDetail userDetailDto) {
        UserDetail userDetail = userDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDetail not found"));
        userDetail.setType(userDetailDto.getType());
        userDetail.setCenter(userDetailDto.getCenter());
        UserDetail updatedDetail = userDetailRepository.save(userDetail);
        return convertToDto(updatedDetail); // 업데이트 후 DTO로 반환
    }

    // 사용자 상세 정보 삭제
    public void deleteUserDetail(Long id) {
        userDetailRepository.deleteById(id);
    }

    // 엔티티 -> DTO 변환 메서드
    private UserDetailDto convertToDto(UserDetail userDetail) {
        UserDetailDto dto = new UserDetailDto();
        dto.setId(userDetail.getUserDetailId());
        return dto;
    }

    // DTO -> 엔티티 변환 메서드
    private UserDetail convertToEntity(UserDetail userDetailDto) {
        UserDetail userDetail = new UserDetail();
        userDetail.setType(userDetailDto.getType());
        return userDetail;
    }

}
