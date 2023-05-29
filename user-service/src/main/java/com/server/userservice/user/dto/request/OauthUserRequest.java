package com.server.userservice.user.dto.request;

import com.server.userservice.user.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OauthUserRequest {

    private String nickname;
    private String profileImageUrl;

    public User toEntity(){
        return User.builder()
                .nickname(this.nickname)
                .profileImageUrl(this.profileImageUrl)
                .build();

    }
}
