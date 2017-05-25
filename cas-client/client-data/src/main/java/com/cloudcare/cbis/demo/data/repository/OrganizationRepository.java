package com.cloudcare.cbis.demo.data.repository;

import com.cloudcare.data.api.ModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.model.Organization;

import com.cloudcare.cbis.demo.data.entity.EOrganization;

import com.cloudcare.common.lang.annotation.Label;

/**
 * OrganizationRepository is a Querydsl repository interface type
 */
@Label("Organization存储")
public interface OrganizationRepository extends ModelQueryAndBatchUpdateRepository<Organization, EOrganization, Integer> {

}

