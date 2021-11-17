package toy.playvip.user.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import toy.playvip.common.response.Response;
import toy.playvip.common.exception.BaseException;
import toy.playvip.user.dto.request.SigninRequestDto;
import toy.playvip.user.dto.request.SignupRequestDto;
import toy.playvip.user.dto.response.TokenResponseDto;
import toy.playvip.user.domain.User;
import toy.playvip.user.dto.response.UserInfoResponseDto;
import toy.playvip.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User API")
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원 가입 API")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "입력값 에러") })
    @PostMapping("/signup")
    public Response<UserInfoResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) throws BaseException {
        return Response.ofSuccess(userService.createUser(signupRequestDto));
    }

    @ApiOperation(value = "로그인", notes = "로그인 API")
    @PostMapping("/signin")
    public Response<String> signin(@RequestBody SigninRequestDto signinRequestDto){
        return Response.ofSuccess(userService.loginUser(signinRequestDto));
    }

    @ApiOperation(value = "회원 정보 조회", notes = "이메일로 회원 정보 조회")
    @GetMapping("{email}/signin")
    public Response getMemberInfo(@PathVariable String email) {
        return Response.ofSuccess(userService.getMemberInfo(email));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 accessToken", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원 조회")
    @GetMapping(value = "/users")
    public Response<List<UserInfoResponseDto>> findAllUsers(){
        return Response.ofSuccess(userService.findAllUsers());
    }


}

//    // UserResponseDto로 변경 필요
//    @ApiOperation(value = "내 정보 조회", notes = "내 정보 조회 API")
//    @GetMapping("/me")
//    public ApiResponse<User> getMyMemberInfo(){
//        return ApiResponse.ofSuccess(userService.getMyInfo());
//    }