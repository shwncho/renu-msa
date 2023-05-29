package com.server.nutrientservice.nutrient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {

    private Long commentId;

    public static CommentResponse from(Long commentId){
        return CommentResponse.builder()
                .commentId(commentId)
                .build();
    }
}
