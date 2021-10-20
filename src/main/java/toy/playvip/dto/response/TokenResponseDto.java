package toy.playvip.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private Long id;
    private String email;
    private String username;
    private Integer role;
}