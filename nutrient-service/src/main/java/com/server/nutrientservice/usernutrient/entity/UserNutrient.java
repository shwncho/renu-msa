package com.server.nutrientservice.usernutrient.entity;

import com.server.nutrientservice.common.entity.BaseEntity;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserNutrient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_nutrient_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nutrient_id")
    private Nutrient nutrient;

    private Long userId;

    @Builder
    public UserNutrient(Nutrient nutrient, Long userId) {
        this.nutrient = nutrient;
        this.userId = userId;
    }

    public static UserNutrient of(Nutrient nutrient, Long userId){
        return UserNutrient.builder()
                .nutrient(nutrient)
                .userId(userId)
                .build();
    }
}
