package dto;

import lombok.Data;

/**
 * 批量查询请求体
 * 游标首次请求为null则按照默认游标，之后可传入请求中返回的下一页的游标
 * 关键词keyword 不同的查找策略传入不同的数据
 * 标签查询：标签名
 * 模糊查询：模型模糊名字
 * 用户模型查询：用户uuid
 */
@Data
public class ModelBatchQueryRequest {
    /**
     * {@link ModelBatchQueryCursor} 标识页的游标
     */
    private ModelBatchQueryCursor cursor;

    //排序策略（latest, hottest）推荐当中的最新和最热
    private String sortStrategy;

    //页大小
    private Integer pageSize;

    //关键词（标签，模糊名字，用户id。。。。）
    private String keyword;

    //默认请求
    {
        cursor = new ModelBatchQueryCursor();
        sortStrategy = "latest";
        pageSize = 10;
        keyword = "%";
    }
}
