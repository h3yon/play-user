package toy.playvip.common.exception.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SecurityExceptionCode {
    USER_DISABLED(403, "회원 상태가 휴면 처리 되어 있습니다. 관리자에게 요청 주세요"),
    TOKEN_EXPIRED(403, "만료된 토큰입니다"),
    TOKEN_PARSE_ERROR(403, "token 처리에 실패했습니다");

    private final Integer code;
    private final String message;

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
