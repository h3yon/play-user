package toy.playvip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class CAuthenticationEntryPointException extends BaseException {

    @Getter
    @RequiredArgsConstructor
    enum CAuthenticationEntryPointExceptionCode{
        SECURITY_ERROR(403, "security 관련 처리에 실패했습니다");

        private final Integer code;
        private final String message;
    }
    public CAuthenticationEntryPointException(CAuthenticationEntryPointExceptionCode exception) {
        super(exception.code, exception.message);
    }

    public CAuthenticationEntryPointException(Integer code, String message) {
        super(code, message);
    }
}