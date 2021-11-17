package toy.playvip.common.exception.security;

import lombok.Getter;
import toy.playvip.common.exception.BaseException;

@Getter
public class SecurityException extends BaseException {

    public SecurityException(SecurityExceptionCode status) {
        super(status.getCode(), status.getMessage());
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

}
