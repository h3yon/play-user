package toy.playvip.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import toy.playvip.common.ApiResponse;
import toy.playvip.dto.request.SigninRequestDto;
import toy.playvip.dto.request.SignupRequestDto;
import toy.playvip.dto.response.TokenResponseDto;
import toy.playvip.entity.User;
import toy.playvip.service.UserService;

import javax.validation.Valid;

@Api(value = "User API")
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원 가입 API")
    @PostMapping("/signup")
    public ApiResponse<User> signup(@Valid @RequestBody SignupRequestDto signupRequestDto){
        return ApiResponse.ofSuccess(userService.createUser(signupRequestDto));
    }

    @ApiOperation(value = "로그인", notes = "로그인 API")
    @PostMapping("/signin")
    public ApiResponse<TokenResponseDto> signin(@RequestBody SigninRequestDto signinRequestDto){
        return ApiResponse.ofSuccess(userService.loginUser(signinRequestDto));
    }

    @ApiOperation(value = "회원 정보 조회", notes = "이메일로 회원 정보 조회")
    @GetMapping("/{email}")
    public ApiResponse getMemberInfo(@PathVariable String email) {
        return ApiResponse.ofSuccess(userService.getMemberInfo(email));
    }

}

//    // UserResponseDto로 변경 필요
//    @ApiOperation(value = "내 정보 조회", notes = "내 정보 조회 API")
//    @GetMapping("/me")
//    public ApiResponse<User> getMyMemberInfo(){
//        return ApiResponse.ofSuccess(userService.getMyInfo());
//    }