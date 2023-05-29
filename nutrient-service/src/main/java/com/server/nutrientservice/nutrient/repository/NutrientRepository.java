package com.server.nutrientservice.nutrient.repository;

import com.server.nutrientservice.nutrient.entity.Category;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutrientRepository extends CrudRepository<Nutrient, Long> {

    @Query(value = "select distinct n from Nutrient n" +
            " left join fetch n.comments " +
            " where n.category = :category ")
    List<Nutrient> findAllByCategory(@Param("category") Category category);
}
