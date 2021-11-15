package toy.playvip.common.response;

import lombok.*;
import toy.playvip.common.exception.BaseException;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {

    private Integer code;
    private String message;
    private T data;

    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> ApiResponse<T> of(Integer code, String message, T data) {
        return new ApiResponse(code, message, data);
    }

    public static <T> ApiResponse<T> ofSuccess() {
        return ofSuccess(null);
    }

    public static <T> ApiResponse<T> ofSuccess(T data) {
        return ofStatus(Status.SUCCESS, data);
    }

    public static <T> ApiResponse<T> ofMessage(String message) {
        return of(Status.SUCCESS.getCode(), message, null);
    }

    public static <T> ApiResponse<T> ofStatus(Status status) {
        return ofStatus(status, null);
    }

    public static <T> ApiResponse<T> ofStatus(IStatus status, T data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    public static <T extends BaseException> ApiResponse ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }

}
