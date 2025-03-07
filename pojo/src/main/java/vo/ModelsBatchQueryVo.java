package vo;

import dto.ModelBatchQueryCursor;
import lombok.Data;

import java.util.List;

/**
 * 模型批量查询返回数据
 */
@Data
public class ModelsBatchQueryVo {
    //模型卡片
    private List<ModelBasicInfoVo> models;

    //下一页的游标
    private ModelBatchQueryCursor nextCursor;

    //有无下一页判断
    private boolean hasNext;
}
