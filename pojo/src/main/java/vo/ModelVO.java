package vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelVO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("hash")
    private String hash;

    @JsonProperty("sha256")
    private String sha256;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("config")
    private String config;

}
