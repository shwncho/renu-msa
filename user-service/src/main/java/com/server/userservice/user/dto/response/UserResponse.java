package com.server.userservice.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String nickname;

    private String profileImageUrl;

    private UserNutrientResponses userNutrients;

    public static UserResponse of(String nickname, String profileImageUrl, UserNutrientResponses userNutrientResponses){
        return UserResponse.builder()
                .nickname(nickname)
                .profileImageUrl(profileImageUrl)
                .userNutrients(userNutrientResponses)
                .build();
    }
}
