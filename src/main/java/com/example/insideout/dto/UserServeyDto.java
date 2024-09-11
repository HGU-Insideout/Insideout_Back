package com.example.insideout.dto;

import com.example.insideout.controller.form.UserDetailForm;
import com.example.insideout.controller.form.UserServeyForm;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import com.example.insideout.domain.UserServey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserServeyDto {

    private int depression; // 우울증 점수

    private int mentalIllness; // 정신질환 점수

    private int alcohol; // 알코올 중독 점수

    private int stress; // 스트레스 점수

    private int mentalIndex; // 멘탈 지수

    public UserServey toEntity(User user) {
        return UserServey.builder()
                .depression(this.depression)
                .mentalIllness(this.mentalIllness)
                .alcohol(this.alcohol)
                .stress(this.stress)
                .mentalIndex(this.mentalIndex)
                .user(user)
                .build();
    }

    public static UserServeyDto from(UserServeyForm userServeyForm) {
        float sum =((float) (133 - (userServeyForm.getDepression() + userServeyForm.getMentalIllness()
                + userServeyForm.getAlcohol() + userServeyForm.getStress())) /133) * 100;
        // 소수점 첫 번째 자리에서 반올림
        int roundedSum = (int) ((int)Math.round(sum * 10) / 10.0f);

        return UserServeyDto.builder()
                .depression(userServeyForm.getDepression())
                .mentalIllness(userServeyForm.getMentalIllness())
                .alcohol(userServeyForm.getAlcohol())
                .stress(userServeyForm.getStress())
                .mentalIndex(roundedSum)
                .build();
    }

}
