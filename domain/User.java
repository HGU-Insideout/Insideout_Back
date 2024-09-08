package com.example.insideout.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone; //휴대폰 번호

    @Column(nullable = false)
    private String gender; //성별

    @Column(nullable = false)
    private String birthday; //생년월일


    private String domitory; //생활관


    private String insurance; //건강 보험 여부

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetail userDetail;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserServey userSurvey;  // UserSurvey와 1:1 관계

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Checklist checklist;  // Checklist와 1:1 관계
}
