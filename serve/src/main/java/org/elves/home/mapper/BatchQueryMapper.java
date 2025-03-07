package org.elves.home.mapper;

import dto.ModelBatchQueryCursor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import vo.ModelBasicInfoVo;

import java.util.List;

@Mapper
public interface BatchQueryMapper {
    List<ModelBasicInfoVo> selectModelByTag(
            @Param("cursor") ModelBatchQueryCursor cursor,
            @Param("sortStrategy") String sortStrategy,
            @Param("size") Integer pageSize,
            @Param("tag") String keyword
            );

    List<ModelBasicInfoVo> selectModelByName(
            @Param("cursor") ModelBatchQueryCursor cursor,
            @Param("sortStrategy") String sortStrategy,
            @Param("size") Integer pageSize,
            @Param("keyword") String keyword
    );

    List<ModelBasicInfoVo> selectModelByUserId(
            @Param("cursor") ModelBatchQueryCursor cursor,
            @Param("sortStrategy") String sortStrategy,
            @Param("size") Integer pageSize,
            @Param("userId") String keyword
    );
}
