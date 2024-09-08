package com.example.insideout.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChecklistDto {
    private Long id;
    private int successCount; // 체크리스트 성공 횟수
    private String successYn; // 성공 여부
    private Date date; // 체크리스트 날짜


}
