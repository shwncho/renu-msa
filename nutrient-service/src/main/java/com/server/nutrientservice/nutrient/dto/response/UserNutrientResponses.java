package com.server.nutrientservice.nutrient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserNutrientResponses {

    private List<UserNutrientResponse> userNutrients = new ArrayList<>();

    public static UserNutrientResponses from(List<UserNutrientResponse> userNutrientResponses){
        return UserNutrientResponses.builder()
                .userNutrients(userNutrientResponses)
                .build();
    }
}
