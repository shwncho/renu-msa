package com.server.nutrientservice.nutrient.entity;

import com.server.nutrientservice.common.exception.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.server.nutrientservice.common.exception.nutrient.NutrientErrorCode.UNSUPPORTED_CATEGORY;

@Getter
@AllArgsConstructor
public enum Category {

    FATIGUE("fatigue"),
    DIGESTION("digestion"),
    LIVER("liver"),
    EYES("eyes"),
    BONE("bone");

    private String name;
    private static final Map<String,String> TYPES = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Category::getName, Category::name)));

    public static Category toEnum(String category){
        if(Arrays.stream(values()).noneMatch(c->c.name.equals(category)))
            throw new ApplicationException(UNSUPPORTED_CATEGORY);
        return valueOf(TYPES.get(category));
    }
}
