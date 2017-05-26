package com.cloudcare.cbis.demo.face;

import com.cloudcare.cbis.demo.face.domain.UserInfoResult;
import com.cloudcare.cbis.demo.face.domain.UserRegisterForm;
import com.cloudcare.common.lang.annotation.RemotingService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by ASUS on 2017/5/11.
 */
@RemotingService
public interface UserRemotingService {
    UserInfoResult userRegister(@NotNull @Valid UserRegisterForm userRegisterForm) throws Exception;
    boolean checkUser(String username, String password);
}
