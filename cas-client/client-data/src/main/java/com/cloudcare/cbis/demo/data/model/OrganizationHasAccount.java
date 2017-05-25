package com.cloudcare.cbis.demo.data.model;

import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.cbis.demo.data.model.Organization;
import com.cloudcare.cbis.demo.data.model.Account;
import com.cloudcare.common.lang.annotation.Domain;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import com.cloudcare.common.lang.annotation.BelongsTos;

import com.cloudcare.data.api.AbstractDataModel;

import com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount;

import com.cloudcare.data.api.CreateCheck;

import com.cloudcare.data.api.UpdateCheck;

/**
 * OrganizationHasAccount is a Codegen model type
 */
@BelongsTos(values = {
	@com.cloudcare.common.lang.annotation.BelongsTo(property="account", rootField="accountId")
,	@com.cloudcare.common.lang.annotation.BelongsTo(property="organization", rootField="organizationId")
})
@Label("OrganizationHasAccount")
@Domain(domainClassName="com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount")
public class OrganizationHasAccount extends AbstractDataModel<EOrganizationHasAccount, Integer> {

    public OrganizationHasAccount() {
    }

    @Label("accountId")
    private Account account;

    @Label("id")
    private Integer id;

    @Label("organizationId")
    private Organization organization;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
         return String.format("OrganizationHasAccount { account : %s,id : %s,organization : %s }",account,id,organization);
    }

}

