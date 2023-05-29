package com.server.nutrientservice.nutrient.dto.response;

import com.server.nutrientservice.comment.dto.response.CommentResponse;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NutrientResponse {

    private Long nutrientId;

    private String title;

    private String content;

    private String manual;

    private String imageUrl;

    private List<CommentResponse> comments = new ArrayList<>();

    public static NutrientResponse from(Nutrient nutrient){
        return NutrientResponse.builder()
                .nutrientId(nutrient.getId())
                .title(nutrient.getTitle())
                .content(nutrient.getContent())
                .manual(nutrient.getManual())
                .imageUrl(nutrient.getImageUrl())
                .comments(nutrient.getComments().stream().map(CommentResponse::from).collect(Collectors.toList()))
                .build();
    }
}
