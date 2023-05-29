package com.server.userservice.user.controller;

import com.server.userservice.user.dto.request.OauthUserRequest;
import com.server.userservice.user.dto.response.OauthUserResponse;
import com.server.userservice.user.dto.response.UserResponse;
import com.server.userservice.user.entity.User;
import com.server.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Optional<User> getUser(@RequestParam String nickname){
        return userService.getUser(nickname);
    }

    @PostMapping("")
    public OauthUserResponse createUser(@RequestBody OauthUserRequest oauthUserRequest){
        return userService.createUser(oauthUserRequest);
    }

    @GetMapping("/me")
    public UserResponse getMe(@RequestHeader("user_id") String userId){
        return userService.getMe(userId);
    }
}
