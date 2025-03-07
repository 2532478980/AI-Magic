package org.elves.home.service;

import vo.ModelInfoVo;
import vo.UserBasicInfoVo;


public interface HomeBasicService {
    ModelInfoVo getModelInfo(String modelId);
    UserBasicInfoVo getUserBasicInfo(String userId);
}
