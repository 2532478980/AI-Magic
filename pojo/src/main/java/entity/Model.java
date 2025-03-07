package entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Model {
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
}
