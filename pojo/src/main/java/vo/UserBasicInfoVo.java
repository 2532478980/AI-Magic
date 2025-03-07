package vo;

import lombok.Data;

/**
 * 用户基础信息
 */
@Data
public class UserBasicInfoVo {
    private String username;
    //头像
    private String avatarUrl;
    //封面
    private String coverUrl;
    //简介
    private String intro;
}
