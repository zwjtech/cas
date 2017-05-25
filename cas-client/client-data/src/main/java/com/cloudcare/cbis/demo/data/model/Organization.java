package com.cloudcare.cbis.demo.data.model;

import javax.validation.constraints.Size;
import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.common.lang.annotation.Domain;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import com.cloudcare.cbis.demo.face.dict.OrganizationType;

import com.cloudcare.data.api.AbstractDataModel;

import com.cloudcare.cbis.demo.data.entity.EOrganization;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

/**
 * Organization is a Codegen model type
 */
@Label("Organization")
@Domain(domainClassName="com.cloudcare.cbis.demo.data.entity.EOrganization")
public class Organization extends AbstractDataModel<EOrganization, Integer> {

    public Organization() {
    }

    @Label("id")
    private Integer id;

    @Label("name")
    @Size(max=128)
    private String name;

    @Label("orgType")
    private OrganizationType orgType;

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

    public OrganizationType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrganizationType orgType) {
        this.orgType = orgType;
    }

    @Override
    public String toString() {
         return String.format("Organization { id : %s,name : %s,orgType : %s }",id,name,orgType);
    }

}

