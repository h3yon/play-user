package toy.playvip.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import toy.playvip.common.response.Status;

@Getter
public class SecurityException extends BaseException{

    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

}
