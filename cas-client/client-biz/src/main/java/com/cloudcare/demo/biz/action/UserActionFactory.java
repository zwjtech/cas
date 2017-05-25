package com.cloudcare.demo.biz.action;

import com.cloudcare.common.lang.exception.BadRequestException;
import com.cloudcare.demo.biz.service.UserService;
import com.cloudcare.cbis.demo.data.model.Account;
import com.cloudcare.web.api.annotation.Action;
import com.cloudcare.cbis.demo.face.UserRemotingService;
import com.cloudcare.cbis.demo.face.domain.UserInfoResult;
import com.cloudcare.cbis.demo.face.domain.UserRegisterForm;
import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.web.api.support.AbstractActionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by ASUS on 2017/5/11.
 */
@Controller("UserDemo")
@Label("demo用户模块")
public class UserActionFactory extends AbstractActionFactory implements UserRemotingService {

    @Autowired
    private UserService userService;

    @Action
    @Label("demo用户注册")
    public UserInfoResult userRegister(@NotNull @Valid UserRegisterForm userRegisterForm){
        UserInfoResult result=new UserInfoResult();
        try{
            Account model=userService.userRegister(userRegisterForm);
            //logger.mark("User register", true, "user", model.getId(), "User register success.", "username : " + model.getName());


            result.setAccountId(model.getId());
            result.setUsername(model.getName());
            return result;

        }catch (Exception e){
            throw e;


        }
    }

    @Action
    @Label("demo用户登陆")
    public boolean checkUser(@Label("用户名") String username,@Label("密码")String password){
        return userService.checkUser(username,password);
    }
}
