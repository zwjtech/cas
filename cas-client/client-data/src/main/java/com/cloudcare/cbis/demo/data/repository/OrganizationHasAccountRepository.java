package com.cloudcare.cbis.demo.data.repository;

import com.cloudcare.data.api.ModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.model.OrganizationHasAccount;

import com.cloudcare.cbis.demo.data.entity.EOrganizationHasAccount;

import com.cloudcare.common.lang.annotation.Label;

/**
 * OrganizationHasAccountRepository is a Querydsl repository interface type
 */
@Label("OrganizationHasAccount存储")
public interface OrganizationHasAccountRepository extends ModelQueryAndBatchUpdateRepository<OrganizationHasAccount, EOrganizationHasAccount, Integer> {

}

