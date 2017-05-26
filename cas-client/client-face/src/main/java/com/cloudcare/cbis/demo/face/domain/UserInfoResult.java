package com.cloudcare.cbis.demo.face.domain;

import com.cloudcare.common.lang.BaseBean;

/**
 * Created by ASUS on 2017/5/11.
 */
public class UserInfoResult implements BaseBean{
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    private Integer accountId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
}
