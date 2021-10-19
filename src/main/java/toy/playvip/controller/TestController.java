package toy.playvip.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.playvip.common.ApiResponse;
import toy.playvip.common.BaseException;
import toy.playvip.common.Status;

@Api(value = "테스트 API")
@RequestMapping("/test")
@RestController
public class TestController {
    @ApiOperation(value = "응답 테스트", notes = "응답(code, message, data)가 잘 나오는지에 대한 테스트")
    @GetMapping
    public ApiResponse list(){
        return ApiResponse.ofMessage("테스트 리스트 조회");
    }

    @ApiOperation(value = "exception 테스트", notes = "code: 500, message: 실패, data:null로 예외 처리 테스트")
    @GetMapping("/exception")
    public ApiResponse exceptionTest(){
        throw new BaseException(Status.ERROR);
    }
}
