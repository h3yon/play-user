package toy.playvip.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="General", description="Common Api Response")
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -123123L;

    @ApiModelProperty(value = "code", required = true)
    private Integer code;

    @ApiModelProperty(value = "message", required = true)
    private String message;

    @ApiModelProperty(value = "data", required = true)
    private T data;

}
