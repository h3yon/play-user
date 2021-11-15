package toy.playvip.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toy.playvip.common.response.IStatus;
import toy.playvip.common.response.Status;

@Getter
@Setter
@NoArgsConstructor
public class ApiException<T> {

    private Integer code;
    private String message;

    public ApiException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static <T extends BaseException> ApiException<T> of(T t) {
        return new ApiException(t.getCode(), t.getMessage());
    }

}
