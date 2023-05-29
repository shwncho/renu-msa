package com.server.authentication.auth.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String nickname;
    private String profileImageUrl;
}
