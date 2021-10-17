package toy.playvip.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import toy.playvip.common.ApiResponse;
import toy.playvip.common.BaseException;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ApiResponse demoErrorHandler(BaseException exception) {
        log.error("【Error】:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }
}
