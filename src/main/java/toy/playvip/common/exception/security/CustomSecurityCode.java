package toy.playvip.common.exception.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomSecurityCode {
    SECURITY_ERROR(403, "security 관련 처리에 실패했습니다"),
    ACCESS_DENIED(403, "접근 권한이 없습니다");

    private final Integer code;
    private final String message;
}
