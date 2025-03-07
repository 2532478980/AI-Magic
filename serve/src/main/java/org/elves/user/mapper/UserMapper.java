package org.elves.user.mapper;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.UUID;

@Mapper
public interface UserMapper {

@Insert("insert into `ai-magic`.users ( account, password_hash, username, phone,email,created_at,last_login,status)" +
        "values (#{account},#{password_hash},#{username},#{phone},#{email},#{created_at},#{last_login},#{status})")
    void register(User user);


@Select("select * from users where phone = #{phone}")
    User selectByPhone(String phone);

@Update("update users set password_hash = #{password_hash} where user_id = #{user_id}")
    void upatePassword(UUID user_id, String password_hash);
}
