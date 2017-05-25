package com.cloudcare.cbis.demo.data.model;

import javax.validation.constraints.Size;
import com.cloudcare.common.lang.annotation.Label;
import org.joda.time.DateTime;
import com.cloudcare.common.lang.annotation.Domain;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

import com.cloudcare.data.api.AbstractDataModel;

import com.cloudcare.cbis.demo.data.entity.EAccount;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

/**
 * Account is a Codegen model type
 */
@Label("Account")
@Domain(domainClassName="com.cloudcare.cbis.demo.data.entity.EAccount")
public class Account extends AbstractDataModel<EAccount, Integer> {

    public Account() {
    }

    @Label("createTime")
    private DateTime createTime;

    @Label("id")
    private Integer id;

    @Label("name")
    @Size(max=45)
    private String name;

    @Label("password")
    @Size(max=64)
    private String password;

    @Label("updateTime")
    private DateTime updateTime;

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
         return String.format("Account { createTime : %s,id : %s,name : %s,password : %s,updateTime : %s }",createTime,id,name,password,updateTime);
    }

}

