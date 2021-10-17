package toy.playvip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.playvip.common.ApiResponse;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping
    public ApiResponse list(){
        return ApiResponse.ofMessage("테스트 리스트 조회");
    }

    @PostMapping
    public ApiR
}
