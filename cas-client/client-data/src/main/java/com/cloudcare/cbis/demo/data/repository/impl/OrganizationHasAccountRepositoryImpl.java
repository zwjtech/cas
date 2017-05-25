package com.cloudcare.cbis.demo.data.repository.impl;

import com.cloudcare.data.querydsl.support.AbstractModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount;

import com.cloudcare.cbis.demo.data.model.OrganizationHasAccount;

import com.cloudcare.cbis.demo.data.repository.OrganizationHasAccountRepository;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.common.lang.annotation.Label;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * OrganizationHasAccountRepositoryImpl is a Querydsl repository implement type
 */
@Label("OrganizationHasAccount存储实现")
@Validated({})
@Repository("organizationHasAccountRepository")
public class OrganizationHasAccountRepositoryImpl extends AbstractModelQueryAndBatchUpdateRepository<EOrganizationHasAccount, Integer, OrganizationHasAccount> implements OrganizationHasAccountRepository {

    @Autowired
    public OrganizationHasAccountRepositoryImpl(DataSource dataSource) {
    	super(dataSource);
    }
    
}

