package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    // 회원 저장 api
    @PostMapping("/users")
    public void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }

    // 회원 조회 api
    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            responses.add(new UserResponse(i + 1, users.get(i)));
        }
        return responses;
    }
}
