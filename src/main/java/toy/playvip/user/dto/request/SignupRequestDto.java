package toy.playvip.user.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignupRequestDto {

    @Email
    private String email;
    @Pattern(
            regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다."
    )
    private String password;
    @Size(min = 2, max = 3, message = "이름은 2~3자 이여야 합니다!")
    private String username;
}