package toy.playvip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SignExceptionCode {
    FAIL_SIGNUP_OVERLAPPED_EMAIL(400, "이미 존재하는 정보입니다"),
    NO_EXISTS_EMAIL(400, "해당 이메일이 존재하지 않습니다");

    private final Integer code;
    private final String message;
}
