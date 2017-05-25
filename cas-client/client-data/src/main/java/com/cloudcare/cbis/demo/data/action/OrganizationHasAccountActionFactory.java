package com.cloudcare.cbis.demo.data.action;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.data.api.DataAdminModule;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.cbis.demo.data.model.OrganizationHasAccount;
import com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloudcare.web.api.support.AbstractCrudModelActionFactory;
import org.springframework.stereotype.Controller;
import com.cloudcare.cbis.demo.data.repository.OrganizationHasAccountRepository;

/**
 * OrganizationHasAccountActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("OrganizationHasAccount数据管理")
@Validated({})
@Controller("OrganizationHasAccountDataAdmin")
public class OrganizationHasAccountActionFactory extends AbstractCrudModelActionFactory<OrganizationHasAccountRepository, OrganizationHasAccount, EOrganizationHasAccount, Integer> {

    @Autowired
    public OrganizationHasAccountActionFactory(OrganizationHasAccountRepository organizationHasAccountRepository) {
        super(organizationHasAccountRepository);
    }

}

