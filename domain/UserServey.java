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
public class UserServey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userServeyId;


    private int depression; //우울증
    private int mentalIllness; //정신질환
    private int alcohol; //알코올 중독
    private int stress; //스트레스
    private int mentalIndex; //멘탈지수리스트

    @OneToOne
    @JoinColumn(name = "user_id")  // User와 1:1 관계 설정 (Foreign Key)
    private User user;
}
