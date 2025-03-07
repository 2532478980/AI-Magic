package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 分页查询游标，标识下一页的依据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModelBatchQueryCursor {
    /**
     * 排序，分页的依据
     */
    private String modelId;
    private LocalDateTime createdAt;
    private Integer likeCount;

    //默认游标
    {
        createdAt = LocalDateTime.now();
        modelId = "00000000-0000-0000-0000-000000000000";
        likeCount = 0;
    }
}
