package com.cloudcare.cbis.demo.data.action;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.data.api.DataAdminModule;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.common.lang.annotation.Label;
import com.cloudcare.cbis.demo.data.model.Organization;
import com.cloudcare.cbis.demo.data.entity.EOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloudcare.web.api.support.AbstractCrudModelActionFactory;
import org.springframework.stereotype.Controller;
import com.cloudcare.cbis.demo.data.repository.OrganizationRepository;

/**
 * OrganizationActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("Organization数据管理")
@Validated({})
@Controller("OrganizationDataAdmin")
public class OrganizationActionFactory extends AbstractCrudModelActionFactory<OrganizationRepository, Organization, EOrganization, Integer> {

    @Autowired
    public OrganizationActionFactory(OrganizationRepository organizationRepository) {
        super(organizationRepository);
    }

}

