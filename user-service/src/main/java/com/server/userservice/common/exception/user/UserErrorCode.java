package com.server.userservice.common.exception.user;

import com.server.userservice.common.exception.ErrorEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorEnumCode {

    USER_NOT_FOUND("U001","존재하지 않는 유저입니다."),
    ;

    private final String code;
    private final String message;
}
