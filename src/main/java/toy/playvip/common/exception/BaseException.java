package toy.playvip.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toy.playvip.common.response.Status;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;
//    private Object data;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
