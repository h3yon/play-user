package toy.playvip.common.exception;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.playvip.common.response.Response;

import static toy.playvip.common.exception.CAuthenticationEntryPointException.CAuthenticationEntryPointExceptionCode.SECURITY_ERROR;

@Api(value = "exception")
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @ApiOperation(value = "exception entrypoint", notes = "exception 발생 uri")
    @GetMapping(value = "/entrypoint")
    public Response entrypointException() {
        throw new CAuthenticationEntryPointException(SECURITY_ERROR);
    }
}