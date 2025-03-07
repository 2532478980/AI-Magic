package org.elves.user.service;

import dto.ForgetPasswordDTO;
import dto.UserDTO;
import dto.UserLoginDTO;
import result.Result;

public interface UserService {

public  void register(UserDTO userDTO);

public  Result userLogin(UserLoginDTO userLoginDTO);

public Result forgetPassword(UserDTO userDTO );

}
