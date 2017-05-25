package com.cloudcare.cbis.demo.data.entity;

import com.cloudcare.data.api.AbstractIdEntity;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

import com.cloudcare.common.lang.annotation.Uniques;
import com.cloudcare.common.lang.annotation.Label;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

/**
 * EOrganizationHasAccount is a Querydsl bean type
 */
@Uniques(values = {
	@com.cloudcare.common.lang.annotation.Unique({"id"})
})
@Label("OrganizationHasAccount")
public class EOrganizationHasAccount extends AbstractIdEntity<Integer> {

    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Label("accountId")
    private Integer accountId;

    @NotNull(groups={UpdateCheck.class})
    @Label("id")
    private Integer id;

    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Label("organizationId")
    private Integer organizationId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public void setDefaultValue() {
    }

    @Override
    public String toString() {
         return String.format("EOrganizationHasAccount { accountId : %s,id : %s,organizationId : %s }",accountId,id,organizationId);
    }

}

