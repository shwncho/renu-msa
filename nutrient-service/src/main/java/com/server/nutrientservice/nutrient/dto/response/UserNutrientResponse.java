package com.server.nutrientservice.nutrient.dto.response;

import com.server.nutrientservice.nutrient.entity.Nutrient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserNutrientResponse {

    private Long nutrientId;

    private String title;

    private String imageUrl;

    public static UserNutrientResponse from(Nutrient nutrient){
        return UserNutrientResponse.builder()
                .nutrientId(nutrient.getId())
                .title(nutrient.getTitle())
                .imageUrl(nutrient.getImageUrl())
                .build();
    }
}
