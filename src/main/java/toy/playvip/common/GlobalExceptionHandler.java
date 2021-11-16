package toy.playvip.common;

import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import toy.playvip.common.exception.BaseException;
import toy.playvip.common.response.Response;
import toy.playvip.common.response.Status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public Response exceptionHandler(BaseException exception) {
        return Response.ofException(exception);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = SecurityException.class)
    public Response securityErrorHandler(BaseException exception) {
        return Response.ofException(exception);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handleValidationException(MethodArgumentNotValidException exception) {
        return Response.ofException(new BaseException(Status.BAD_PARAMS));
    }

}
