package org.elves.user.controller;

import dto.UserDTO;
import dto.UserLoginDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.elves.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

@RestController
@RequestMapping("/user")
@Api(tags = "账户相关接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.userLogin(userLoginDTO);
    }

    @PostMapping("/forgetPassword")
    public Result forgetPassword(@RequestBody UserDTO userDTO){
        return userService.forgetPassword(userDTO);
    }
}
