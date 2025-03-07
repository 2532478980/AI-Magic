package vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 模型详细信息，模型页面显示信息
 */
@Data
public class ModelInfoVo {
    private String modelId;
    private String name;
    private String creatorId;
    private String coverUrl;
    private String modelUrl;
    private String description;
    private String type;
    private String category;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
    private Integer modelSize;
    private Integer downloadCount;
    private Integer likeCount;
    private Integer status;

    private String username;
    private String avatarUrl;
}
