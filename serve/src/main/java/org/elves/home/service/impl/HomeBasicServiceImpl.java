package org.elves.home.service.impl;

import org.elves.home.mapper.HomeBasicMapper;
import org.elves.home.service.HomeBasicService;
import org.springframework.stereotype.Service;
import vo.ModelInfoVo;
import vo.UserBasicInfoVo;

@Service
public class HomeBasicServiceImpl implements HomeBasicService {
    private final HomeBasicMapper homeBasicMapper;
    public HomeBasicServiceImpl(HomeBasicMapper homeBasicMapper) {
        this.homeBasicMapper = homeBasicMapper;
    }

    /**
     * 获取模型详细数据
     * @param modelId 模型uuid
     * @return {@link ModelInfoVo}
     */
    @Override
    public ModelInfoVo getModelInfo(String modelId) {
        return homeBasicMapper.SelectModelInfoById(modelId);
    }

    /**
     * 获取用户基本信息
     * @param userId 用户uuid
     * @return {@link UserBasicInfoVo}
     */
    @Override
    public UserBasicInfoVo getUserBasicInfo(String userId) {
        return homeBasicMapper.SelectUserBasicInfoById(userId);
    }
}
