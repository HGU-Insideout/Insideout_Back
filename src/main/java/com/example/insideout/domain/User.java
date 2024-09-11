package com.example.insideout.domain;

import com.example.insideout.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Basetime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;  // 사용자 ID

    @Column(nullable = false)
    private String username;  // 사용자 로그인 ID

    @Column(nullable = false)
    private String password;  // 사용자 비밀번호

    @Column(nullable = false)
    private String phone; // 사용자 휴대폰 번호

    @Column(nullable = false)
    private String gender; // 사용자 성별

    @Column(nullable = false)
    private String birthday; // 사용자 생년월일

    private String domitory; // 생활관 정보

    private String insurance; // 건강 보험 여부

    public static User toUser(UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .gender(userDto.getGender())
                .birthday(userDto.getBirthday())
                .domitory(userDto.getDomitory())
                .insurance(userDto.getInsurance())
                .build();
    }

    public void update(UserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.phone = userDto.getPhone();
        this.gender = userDto.getGender();
        this.birthday = userDto.getBirthday();
        this.domitory = userDto.getDomitory();
        this.insurance = userDto.getInsurance();

    }





}
