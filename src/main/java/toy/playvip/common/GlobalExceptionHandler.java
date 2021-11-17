package toy.playvip.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import toy.playvip.common.exception.*;
import toy.playvip.common.exception.security.CAuthenticationEntryPointException;
import toy.playvip.common.exception.security.SignException;
import toy.playvip.common.response.Response;
import toy.playvip.common.response.Status;

import java.lang.SecurityException;
import java.util.NoSuchElementException;

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
    @ExceptionHandler(value = SignException.class)
    public Response emailSigninExceptionHandler(SignException exception) {
        return Response.ofException(exception);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handleValidationException(MethodArgumentNotValidException exception) {
        return Response.ofException(new BaseException(Status.BAD_PARAMS));
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {IllegalArgumentException.class, NoSuchElementException.class})
    public Response handleAssertException(IllegalArgumentException exception) {
        return Response.ofException(new BaseException(Status.NO_EXISTS_INFO));
    }


    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = CAuthenticationEntryPointException.class)
    public Response CAuthenticationEntryPointExceptionHandler(CAuthenticationEntryPointException exception) {
        return Response.ofException(exception);
    }



//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(SecurityException.class)
//    public Response authenticationEntryPointException(HttpServletRequest request, SecurityException exception) {
//        return Response.ofException(exception);
//    }
}
