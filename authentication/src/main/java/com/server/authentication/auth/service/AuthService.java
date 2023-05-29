package com.server.authentication.auth.service;

import com.server.authentication.auth.client.UserFeignClient;
import com.server.authentication.auth.dto.response.LoginResponse;
import com.server.authentication.auth.entity.User;
import com.server.authentication.infrastructure.KaKaoRequester;
import com.server.authentication.oauth.KaKaoOauthUserInfo;
import com.server.authentication.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserFeignClient userFeignClient;
    private final KaKaoRequester kaKaoRequester;
    private final JwtProvider jwtProvider;

    @Transactional
    public LoginResponse login(String code){
        KaKaoOauthUserInfo kaKaoOauthUserInfo = kaKaoRequester.getUserInfoByCode(code);
        User user = userFeignClient.getUser(kaKaoOauthUserInfo.getNickname())
                .orElseGet(()->createOauthUser(kaKaoOauthUserInfo));
        return LoginResponse.of(user.getId(), jwtProvider.createAccessToken(user.getId().toString()));
    }

    private User createOauthUser(KaKaoOauthUserInfo client){
        return userFeignClient.createUser(User.builder()
                .nickname(client.getNickname())
                .profileImageUrl(client.getProfileImageUrl())
                .build());
    }
}
