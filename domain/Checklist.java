package com.example.insideout.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checklistId;

    private String UserId;
    private int successNum;
    private String successOX;
    private Date successDate;

    @OneToOne
    @JoinColumn(name = "user_id")  // User와 1:1 관계 설정 (Foreign Key)
    private User user;
}
