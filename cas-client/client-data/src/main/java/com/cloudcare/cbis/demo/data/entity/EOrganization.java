package com.cloudcare.cbis.demo.data.entity;

import com.cloudcare.data.api.AbstractIdEntity;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

import com.cloudcare.common.lang.annotation.Uniques;
import javax.validation.constraints.Size;
import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.common.lang.annotation.DictDataType;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

/**
 * EOrganization is a Querydsl bean type
 */
@Uniques(values = {
	@com.cloudcare.common.lang.annotation.Unique({"id"})
})
@Label("Organization")
public class EOrganization extends AbstractIdEntity<Integer> {

    @NotNull(groups={UpdateCheck.class})
    @Label("id")
    private Integer id;

    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Label("name")
    @Size(max=128)
    private String name;

    @DictDataType(com.cloudcare.cbis.demo.face.dict.OrganizationType.class)
    @Label("orgType")
    @Size(max=32)
    private String orgType;

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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Override
    public void setDefaultValue() {
    }

    @Override
    public String toString() {
         return String.format("EOrganization { id : %s,name : %s,orgType : %s }",id,name,orgType);
    }

}

