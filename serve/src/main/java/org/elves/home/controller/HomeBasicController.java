package org.elves.home.controller;

import dto.ModelBatchQueryRequest;
import exception.BaseException;
import io.swagger.annotations.Api;
import org.elves.home.service.impl.BatchQueryServiceImpl;
import org.elves.home.service.impl.HomeBasicServiceImpl;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.ModelInfoVo;
import vo.ModelsBatchQueryVo;
import vo.UserBasicInfoVo;

@Api(tags = "用户基本信息，模型详细信息，用户模型查询")
@RestController
public class HomeBasicController {
    private final HomeBasicServiceImpl homeService;
    private final BatchQueryServiceImpl batchQueryService;

    HomeBasicController(HomeBasicServiceImpl homeService, BatchQueryServiceImpl batchService) {
        this.homeService = homeService;
        this.batchQueryService = batchService;
    }

    /**
     * 用户基本信息查询，用户页面
     *
     * @param userId 用户uuid
     * @return 返回用户基本信息
     */
    @GetMapping("/userpage/{user_id}")
    public Result getUserBasicInfo(@PathVariable("user_id") String userId) throws BaseException{
        UserBasicInfoVo userBasicInfoVo = homeService.getUserBasicInfo(userId);
        if(userBasicInfoVo == null){
            throw new BaseException("user not found");
        }else {
            return Result.success(userBasicInfoVo);
        }
    }

    /**
     * 用户模型查询
     *
     * @param userId 用户uuid
     * @param request {@link ModelBatchQueryRequest} 用户页面的模型查询，默认查询策略为用户模型
     * @return 模型
     */
    @PostMapping("/userpage/{user_id}/model")
    public Result getUserModels(@PathVariable("user_id") String userId, @RequestBody ModelBatchQueryRequest request)
        throws BaseException {
        request.setKeyword(userId);
        //默认为用户模型查询
        ModelsBatchQueryVo response = batchQueryService.queryModel(request, "user");

        if(response != null) {
            return Result.success(response);
        }else{
            throw new BaseException("error");
        }
    }

    /**
     * 模型详细信息
     *
     * @param modelId 模型uuid
     * @return 模型详细信息
     */
    @GetMapping("/modelInfo/{model_id}")
    public Result getModelInfo(@PathVariable("model_id") String modelId) throws BaseException {
        ModelInfoVo modelInfoVo = homeService.getModelInfo(modelId);

        if(modelInfoVo == null){
            throw new BaseException("model not found");
        }else {
            return Result.success(modelInfoVo);
        }
    }
}
