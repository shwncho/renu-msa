package com.server.authentication.auth.controller;

import com.server.authentication.auth.dto.response.LoginResponse;
import com.server.authentication.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("login")
    public LoginResponse login(@RequestParam String code){
        return authService.login(code);
    }

}
