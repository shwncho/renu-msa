package com.server.nutrientservice.usernutrient.repository;

import com.server.nutrientservice.nutrient.entity.Nutrient;
import com.server.nutrientservice.usernutrient.entity.UserNutrient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserNutrientRepository extends JpaRepository<UserNutrient, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    void deleteByUserIdAndNutrient(Long userId, Nutrient nutrient);

    @EntityGraph(attributePaths = {"nutrient"})
    List<UserNutrient> findAllByUserId(Long userId);
}
