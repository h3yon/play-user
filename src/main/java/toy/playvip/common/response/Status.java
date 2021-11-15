package toy.playvip.common.response;

import lombok.Getter;
import toy.playvip.common.response.IStatus;

@Getter
public enum Status implements IStatus {

    /**
     * 성공
     */
    SUCCESS(200, "성공"),
    LOGOUT(200, "로그아웃"),


    /**
     * 실패 (orgin: 500 Internal Server Error)
     */
    ERROR(500, "실패"),

    /**
     * 400 Bad Request
     */
    BAD_REQUEST(400, "허용되지 않는 방식"),
    BAD_PARAMS(400, "입력한 값을 확인해주세요"),
    PARAM_NOT_MATCH(400, "매개변수가 맞지 않습니다"),
    PARAM_NOT_NULL(400, "매개변수의 NULL은 허용되지 않습니다"),

    USERNAME_PASSWORD_ERROR(1001, "잘못된 ID 또는 비밀번호입니다"),

    // 404 Not Found    405 Method Not Allowed
    NO_EXISTS_INFO(404, "해당 정보가 존재하지 않습니다"),
    REQUEST_NOT_FOUND(404, "요청이 발견되지 않습니다"),
    METHOD_NOT_FOUND(405, "허용되지 않는 메서드입니다");

    private Integer code;
    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /* 혹시 모르니까 나중에 필요하면 사용
    public static Status fromCode(Integer code) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return SUCCESS;
    }*/

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMessage());
    }
}
