package org.elves.home.mapper;

import org.apache.ibatis.annotations.Mapper;
import vo.ModelInfoVo;
import vo.UserBasicInfoVo;

@Mapper
public interface HomeBasicMapper {

    ModelInfoVo SelectModelInfoById(String modelId);

    UserBasicInfoVo SelectUserBasicInfoById(String userId);
}
