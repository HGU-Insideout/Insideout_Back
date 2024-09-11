package com.example.insideout.dto;


import com.example.insideout.controller.form.UserDetailForm;
import com.example.insideout.controller.form.UserForm;
import com.example.insideout.domain.User;
import com.example.insideout.domain.UserDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetailDto {

    private String center; // 노숙인 센터 여부

    private String disabilityStatus; // 장애 여부

    private String interest; // 관심사

    private String enter; // 입소일

    private String type; // 장애 유형



    public UserDetail toEntity(User user) {
        return UserDetail.builder()
                .center(this.center)
                .disabilityStatus(this.disabilityStatus)
                .interest(this.interest)
                .enter(this.enter)
                .type(this.type)
                .user(user)
                .build();
    }

    public static UserDetailDto from(UserDetailForm userDetailForm) {
        return UserDetailDto.builder()
                .center(userDetailForm.getCenter())
                .disabilityStatus(userDetailForm.getDisabilityStatus())
                .interest(userDetailForm.getInterest())
                .enter(userDetailForm.getEnter())
                .type(userDetailForm.getType())
                .build();
    }

}
