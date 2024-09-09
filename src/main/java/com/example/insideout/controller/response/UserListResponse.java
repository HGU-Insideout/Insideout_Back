package com.example.insideout.controller.response;


import com.example.insideout.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class UserListResponse {
    private List<User> users;

    public UserListResponse(List<User> users){
        this.users = users;
    }
}