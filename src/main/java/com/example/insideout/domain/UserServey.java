package com.example.insideout.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserServey extends Basetime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userServeyId;  // 설문조사 결과 ID

    private int depression; // 우울증 점수

    private int mentalIllness; // 정신질환 점수

    private int alcohol; // 알코올 중독 점수

    private int stress; // 스트레스 점수

    private int mentalIndex; // 멘탈 지수

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
