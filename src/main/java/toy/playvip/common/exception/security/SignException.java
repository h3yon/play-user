package toy.playvip.common.exception.security;

import toy.playvip.common.exception.BaseException;

public class SignException extends BaseException {

    public SignException(SignExceptionCode status) {
        super(status.getCode(), status.getMessage());
    }

    public SignException(Integer code, String message) {
        super(code, message);
    }

}