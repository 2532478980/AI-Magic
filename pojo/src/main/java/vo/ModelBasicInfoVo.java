package vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 模型基本信息，（模型显示卡片）
 */
@Data
public class ModelBasicInfoVo {
    private String modelId;
    private String name;
    private String creatorId;
    private LocalDateTime createdAt;
    private String coverUrl;
    private String type;
    private Integer downloadCount;
    private Integer likeCount;

    private String username;
    private String avatarUrl;
}
