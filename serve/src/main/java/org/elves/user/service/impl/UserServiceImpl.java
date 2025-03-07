package org.elves.user.service.impl;

import dto.ForgetPasswordDTO;
import org.mindrot.jbcrypt.BCrypt;
import constant.Constant;
import constant.MessageConstant;
import dto.UserDTO;
import dto.UserLoginDTO;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.elves.user.mapper.UserMapper;
import org.elves.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.Result;
import utils.JwtUtil;
import vo.UserVo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
/*
用户注册
 */
    @Override
    public void register(UserDTO userDTO){
        User user = new User();
        log.info(userDTO.getAccount());
        userDTO.setPassword_hash(BCrypt.hashpw(userDTO.getPassword_hash(),BCrypt.gensalt()));
        BeanUtils.copyProperties(userDTO,user);
        log.info(user.getPassword_hash());
        user.setStatus(0);
        user.setCreated_at(LocalDateTime.now());
        user.setLast_login(LocalDateTime.now());
        userMapper.register(user);
    }

    /*
    * 用户登录
    * */
    @Override
    public Result userLogin(UserLoginDTO userLoginDTO){
        log.info(userLoginDTO.getPhone());
        User user  = userMapper.selectByPhone(userLoginDTO.getPhone());
        if (user == null){
            return Result.error(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if (BCrypt.checkpw(user.getPassword_hash(),userLoginDTO.getPassword())){
            UserVo userVo = new UserVo();
            Map<String,Object> claims = new HashMap<>();
            claims.put(Constant.USER_ID,user.getUser_id());
            userVo.setToken(JwtUtil.creatToken(Constant.KEY,claims));
            return Result.success(userVo);
        }
        return Result.error(MessageConstant.PASSWORD_ERROR);
    }
/*
* 忘记密码
* */
    @Override
    public Result forgetPassword(UserDTO userDTO){
        /*
        后续考虑采用验证码方式重置密码
         */
        User user  = userMapper.selectByPhone(userDTO.getPhone());
        if (user == null){
            return Result.error(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        userMapper.upatePassword(user.getUser_id(),BCrypt.hashpw(userDTO.getPassword_hash(),BCrypt.gensalt()));
        return Result.success();
    }

}
