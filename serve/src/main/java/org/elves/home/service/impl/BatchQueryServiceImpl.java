package org.elves.home.service.impl;

import dto.ModelBatchQueryCursor;
import dto.ModelBatchQueryRequest;
import exception.BaseException;
import org.elves.home.mapper.BatchQueryMapper;
import org.elves.home.service.BatchQueryService;
import org.springframework.stereotype.Service;
import vo.ModelBasicInfoVo;
import vo.ModelsBatchQueryVo;

import java.util.List;

@Service
public class BatchQueryServiceImpl implements BatchQueryService {
    private final BatchQueryMapper batchQueryMapper;
    public BatchQueryServiceImpl(BatchQueryMapper batchQueryMapper) {
        this.batchQueryMapper = batchQueryMapper;
    }

    /**
     *
     * @param request 批量查询请求
     * @param findStrategy 查找策略（标签查询，用户模型查询，模型名模糊查询）
     * @return {@link ModelsBatchQueryVo}
     */
    @Override
    public ModelsBatchQueryVo queryModel(ModelBatchQueryRequest request, String findStrategy)
            throws BaseException {
        List<ModelBasicInfoVo> list;

        //判断查询策略
        switch (findStrategy){
            case "tag":
                list = batchQueryMapper.selectModelByTag(
                        request.getCursor(),
                        request.getSortStrategy(),
                        request.getPageSize(),
                        request.getKeyword()
                );
                break;
            case "keyword":
                list = batchQueryMapper.selectModelByName(
                        request.getCursor(),
                        request.getSortStrategy(),
                        request.getPageSize(),
                        request.getKeyword()
                );
                break;
            case "user":
                list = batchQueryMapper.selectModelByUserId(
                        request.getCursor(),
                        request.getSortStrategy(),
                        request.getPageSize(),
                        request.getKeyword()
                );
                break;
            default:
                throw new BaseException("strategy error");
        }

        //创建返回数据
        ModelsBatchQueryVo response = new ModelsBatchQueryVo();
        response.setModels(list);
        //如果没满，就没有下一页，满了就还有下一页
        response.setHasNext(list.size() == request.getPageSize());

        //设置下一页的游标
        if(!list.isEmpty()) {
            ModelBasicInfoVo temp = list.get(list.size() - 1);
            response.setNextCursor(new ModelBatchQueryCursor(
                    temp.getModelId(),
                    temp.getCreatedAt(),
                    temp.getLikeCount()
            ));
        }

        return response;
    }
}
