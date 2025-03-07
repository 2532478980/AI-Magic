package org.elves.home.controller;

import dto.ModelBatchQueryRequest;
import exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.elves.home.service.BatchQueryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.ModelsBatchQueryVo;


@Slf4j
@RestController
@Api(tags = "模型查询")
public class BatchQueryController {
    private final BatchQueryService batchQueryService;
    public BatchQueryController(final BatchQueryService batchQueryService) {
        this.batchQueryService = batchQueryService;
    }

    /**
     * 模型查找
     *
     * @param strategy 查找策略（标签查询 strategy=tag，用户模型查询 strategy=user，模型名模糊查询 strategy=keyword）
     * @param request {@link ModelBatchQueryRequest}
     * @return {@link Result}
     */
    @Operation
    @PostMapping("/query/{strategy}")
    public Result query(@PathVariable("strategy") String strategy, @RequestBody ModelBatchQueryRequest request)
            throws BaseException {
        ModelsBatchQueryVo response = batchQueryService.queryModel(request, strategy);

        if(response != null) {
            return Result.success(response);
        }else{
            throw new BaseException("error");
        }
    }
}
