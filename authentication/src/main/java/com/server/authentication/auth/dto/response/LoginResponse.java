package com.server.authentication.auth.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private Long userId;

    private String accessToken;

    public static LoginResponse of(Long userId, String accessToken){
        return LoginResponse.builder()
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }
}
