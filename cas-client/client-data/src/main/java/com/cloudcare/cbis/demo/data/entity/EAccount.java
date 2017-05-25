package com.cloudcare.cbis.demo.data.entity;

import com.cloudcare.data.api.AbstractStatisticsEntity;

import com.cloudcare.data.api.StatisticsEntity;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

import com.cloudcare.common.lang.annotation.Uniques;
import javax.validation.constraints.Size;
import com.cloudcare.common.lang.annotation.Label;
import org.joda.time.DateTime;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

/**
 * EAccount is a Querydsl bean type
 */
@Uniques(values = {
	@com.cloudcare.common.lang.annotation.Unique({"name"})
})
@Label("Account")
public class EAccount extends AbstractStatisticsEntity<Integer> implements StatisticsEntity {

    @Label("createTime")
    private DateTime createTime;

    @NotNull(groups={UpdateCheck.class})
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
    public void setDefaultValue() {
    }

    @Override
    public String toString() {
         return String.format("EAccount { createTime : %s,id : %s,name : %s,password : %s,updateTime : %s }",createTime,id,name,password,updateTime);
    }

}

