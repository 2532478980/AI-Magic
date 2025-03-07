package vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Img2ImgVO {
    @JsonProperty("images")
    @Valid
    private List<String> images = null;

    @JsonProperty("parameters")
    private Object parameters;

    @JsonProperty("info")
    private String info;
}

