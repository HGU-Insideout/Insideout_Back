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
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;

    private Long UserId;
    private String center; //노숙인 센터 여부
    private String disabilityStatus; //장애 여부
    private String interest; //관심사
    private String enter; //입소일
    private String disabilityType; //장애 유형

    @OneToOne
    @JoinColumn(name = "user_id")  // User와 1:1 관계 설정 (Foreign Key)
    private User user;
}
