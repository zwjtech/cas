package com.cloudcare.demo.biz.service;

import com.cloudcare.cbis.demo.data.model.Account;
import com.cloudcare.cbis.demo.face.domain.UserRegisterForm;

/**
 * Created by ASUS on 2017/5/12.
 */
public interface UserService {
    Account userRegister(UserRegisterForm demoRegisterForm);
    boolean checkUser(String username, String password);
}
