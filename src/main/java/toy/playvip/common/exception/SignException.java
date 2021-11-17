package toy.playvip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import toy.playvip.common.response.IStatus;
import toy.playvip.common.response.Status;

public class SignException extends BaseException{

    public SignException(SignExceptionCode status) {
        super(status.getCode(), status.getMessage());
    }

    public SignException(Integer code, String message) {
        super(code, message);
    }

}