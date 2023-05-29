package com.server.userservice.user.dto.response;

import com.server.userservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OauthUserResponse {

    private Long id;
    private String nickname;
    private String profileImageUrl;

    public static OauthUserResponse from(User user){
        return OauthUserResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
