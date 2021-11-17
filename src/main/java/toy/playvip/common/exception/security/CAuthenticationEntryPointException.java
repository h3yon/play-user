package toy.playvip.common.exception.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import toy.playvip.common.exception.BaseException;

public class CAuthenticationEntryPointException extends BaseException {

    public CAuthenticationEntryPointException(CustomSecurityCode exception) {
        super(exception.getCode(), exception.getMessage());
    }

    public CAuthenticationEntryPointException(Integer code, String message) {
        super(code, message);
    }
}