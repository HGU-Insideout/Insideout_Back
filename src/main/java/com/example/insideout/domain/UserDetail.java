package com.example.insideout.domain;

import com.example.insideout.dto.UserDetailDto;
import com.example.insideout.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends Basetime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;  // 사용자 상세 정보 ID

    private String center; // 노숙인 센터 여부

    private String disabilityStatus; // 장애 여부

    private String interest; // 관심사

    private String enter; // 입소일

    private String type; // 장애 유형

    @OneToOne
    @JoinColumn(name = "user_id") // UserDetail 테이블의 user_id 컬럼이 User 엔티티의 pk와 매핑 / UserDetail에서 User 객체에 접근 가능하게 함
    private User user;


    public static UserDetail toUserDetail(UserDetailDto userDetailDto, User user){
        return UserDetail.builder()
                .center(userDetailDto.getCenter())
                .disabilityStatus(userDetailDto.getDisabilityStatus())
                .interest(userDetailDto.getInterest())
                .enter(userDetailDto.getEnter())
                .type(userDetailDto.getType())
                .user(user)
                .build();
    }

}
