package com.server.nutrientservice.common.exception.nutrient;

import com.server.nutrientservice.common.exception.ErrorEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NutrientErrorCode implements ErrorEnumCode {

    UNSUPPORTED_CATEGORY("N001","지원하지 않는 영양제 종류입니다."),
    NOT_FOUND_NUTRIENT("N002","존재하지 않는 영양제입니다."),
    NOT_FOUND_COMMENT("N003","존재하지 않는 댓글입니다."),
    INVALID_USER("N004","유효하지 않은 유저입니다."),
    ;

    private final String code;
    private String message;
}
