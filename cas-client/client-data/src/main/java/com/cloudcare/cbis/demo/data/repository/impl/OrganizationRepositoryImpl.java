package com.cloudcare.cbis.demo.data.repository.impl;

import com.cloudcare.data.querydsl.support.AbstractModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.entity.EOrganization;

import com.cloudcare.cbis.demo.data.model.Organization;

import com.cloudcare.cbis.demo.data.repository.OrganizationRepository;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.common.lang.annotation.Label;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepositoryImpl is a Querydsl repository implement type
 */
@Label("Organization存储实现")
@Validated({})
@Repository("organizationRepository")
public class OrganizationRepositoryImpl extends AbstractModelQueryAndBatchUpdateRepository<EOrganization, Integer, Organization> implements OrganizationRepository {

    @Autowired
    public OrganizationRepositoryImpl(DataSource dataSource) {
    	super(dataSource);
    }
    
}

