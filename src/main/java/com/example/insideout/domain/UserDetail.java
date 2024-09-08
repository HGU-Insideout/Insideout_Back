package com.example.insideout.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;  // 사용자 상세 정보 ID

    private Long userId;  // 사용자 ID (Foreign Key)

    private String center; // 노숙인 센터 여부
    private String disabilityStatus; // 장애 여부
    private String interest; // 관심사
    private String enter; // 입소일
    private String type; // 장애 유형

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
