package org.elves.home.service;

import dto.ModelBatchQueryRequest;
import vo.ModelsBatchQueryVo;

public interface BatchQueryService {
    ModelsBatchQueryVo queryModel(ModelBatchQueryRequest request, String findStrategy);
}
