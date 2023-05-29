package com.server.authentication.common.exception.auth;

import com.server.authentication.common.exception.ErrorEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorEnumCode {
    USER_EXIST("A001","이미 존재하는 유저입니다."),
    INVALID_PASSWORD("A002","유효하지 않은 패스워드입니다."),
    USER_NOT_FOUND("U001","존재하지 않는 유저입니다."),
    KAKAO_LOGIN("A003","카카오 로그인에 실패했습니다.")

    ;

    private final String code;
    private final String message;
}
