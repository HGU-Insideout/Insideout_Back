package com.example.insideout.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDetailForm {


    private String center; // 노숙인 센터 여부

    private String disabilityStatus; // 장애 여부

    private String interest; // 관심사

    private String enter; // 입소일

    private String type; // 장애 유형
}
