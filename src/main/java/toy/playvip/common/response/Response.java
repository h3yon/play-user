package toy.playvip.common.response;

import lombok.*;
import toy.playvip.common.exception.BaseException;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

    private Integer code;
    private String message;
    private T data;

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> Response<T> of(Integer code, String message, T data) {
        return new Response(code, message, data);
    }

    public static <T> Response<T> ofSuccess() {
        return ofSuccess(null);
    }

    public static <T> Response<T> ofSuccess(T data) {
        return ofStatus(Status.SUCCESS, data);
    }

    public static <T> Response<T> ofMessage(String message) {
        return of(Status.SUCCESS.getCode(), message, null);
    }

    public static <T> Response<T> ofStatus(Status status) {
        return ofStatus(status, null);
    }

    public static <T> Response<T> ofStatus(IStatus status, T data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    public static <T extends BaseException> Response ofException(T t) {
        return of(t.getCode(), t.getMessage(), null);
    }

}
