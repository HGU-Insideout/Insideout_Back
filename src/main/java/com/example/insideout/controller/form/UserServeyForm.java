package com.example.insideout.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserServeyForm {

    private int depression; // 우울증 점수

    private int mentalIllness; // 정신질환 점수

    private int alcohol; // 알코올 중독 점수

    private int stress; // 스트레스 점수

}
