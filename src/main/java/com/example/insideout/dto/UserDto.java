package com.example.insideout.dto;

import com.example.insideout.controller.form.UserForm;
import com.example.insideout.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private String username;  // 사용자 로그인 ID

    private String password;  // 사용자 비밀번호

    private String phone; // 사용자 휴대폰 번호

    private String gender; // 사용자 성별

    private String birthday; // 사용자 생년월일

    private String domitory; // 생활관 정보

    private String insurance; // 건강 보험 여부




    public static UserDto from(UserForm userForm) {
        return UserDto.builder()
                .username(userForm.getUsername())
                .password(userForm.getPassword())
                .phone(userForm.getPhone())
                .gender(userForm.getGender())
                .birthday(userForm.getBirthday())
                .domitory(userForm.getDomitory())
                .insurance(userForm.getInsurance())
                .build();
    }

    public static UserDto from(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .phone(user.getPhone())
                .gender(user.getGender())
                .birthday(user.getBirthday())
                .domitory(user.getDomitory())
                .insurance(user.getInsurance())  // User 객체에서 보험 정보를 가져온다고 가정
                .build();
    }

}