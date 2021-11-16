package toy.playvip.user.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import toy.playvip.user.domain.User;

import java.util.List;

@Data
//@Builder
@ApiModel(description = "유저 목록 조회 파라미터")
public class UserInfoResponseDto {

    @ApiModelProperty(value = "유저 id 번호")
    private Long id;

    @ApiModelProperty(value = "유저 이메일")
    private String email;

    @ApiModelProperty(value = "유저 이름")
    private  String username;

    @ApiModelProperty(value = "유저 역할")
    private List<String> roles;

    public UserInfoResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }
}
