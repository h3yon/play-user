package toy.playvip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import toy.playvip.common.response.Status;

public class EmailSigninFailedException extends BaseException{

    @Getter
    @RequiredArgsConstructor
    public enum EmailSigninExceptionCode {
        NO_EXISTS_INFO(404, "해당 정보가 존재하지 않습니다");

        private final Integer code;
        private final String message;
    };

    public EmailSigninFailedException(Status status) {
        super(status);
    }

    public EmailSigninFailedException(Integer code, String message) {
        super(code, message);
    }

}
