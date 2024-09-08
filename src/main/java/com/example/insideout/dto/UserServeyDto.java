package com.example.insideout.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServeyDto {
    private Long id;
    private int depression; // 우울증 점수
    private int mentalIllness; // 정신질환 점수
    private int alcohol; // 알코올 중독 점수S
    private int stress; // 스트레스 점수
    private int mentalIndex; // 멘탈 지수

}
