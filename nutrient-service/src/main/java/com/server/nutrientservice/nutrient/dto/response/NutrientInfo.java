package com.server.nutrientservice.nutrient.dto.response;

import com.server.nutrientservice.nutrient.entity.Nutrient;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NutrientInfo {

    private Long nutrientId;

    private String title;

    private String imageUrl;

    public static NutrientInfo from(Nutrient nutrient){
        return NutrientInfo.builder()
                .nutrientId(nutrient.getId())
                .title(nutrient.getTitle())
                .imageUrl(nutrient.getImageUrl())
                .build();
    }
}
