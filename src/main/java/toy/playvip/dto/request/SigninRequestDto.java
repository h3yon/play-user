package toy.playvip.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SigninRequestDto {
    @Email
    private String email;
    @NotNull
    private String password;
}