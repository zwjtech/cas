package com.cloudcare.cbis.demo.face.domain;

import com.cloudcare.common.lang.BaseBean;
import com.cloudcare.common.lang.annotation.Label;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by ASUS on 2017/5/11.
 */
@Label("demo用户注册表单")
public class UserRegisterForm implements BaseBean{

    @NotBlank
    @Size(max = 64)
    @Label("用户名")
    private String username;

    @NotBlank
    @Size(max = 64)
    @Label("密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
