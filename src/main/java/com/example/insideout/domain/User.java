package com.example.insideout.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;  // 사용자 ID

    @Column(nullable = false)
    private String id;  // 사용자 로그인 ID

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
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private UserDetail userDetail;  // UserDetail과 1:1 관계
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private UserServey userSurvey;  // UserSurvey와 1:1 관계
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Checklist checklist;  // Checklist와 1:1 관계



}
