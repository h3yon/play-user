package toy.playvip.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SecurityException extends RuntimeException{
    private Integer code;
    private String message;

    public SecurityException(SecurityExceptionCode se) {
        this.code = se.getCode();
        this.message = se.getMessage();
    }
}
