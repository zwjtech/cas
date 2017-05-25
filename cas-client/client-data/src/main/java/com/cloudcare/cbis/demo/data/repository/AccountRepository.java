package com.cloudcare.cbis.demo.data.repository;

import com.cloudcare.data.api.ModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.model.Account;

import com.cloudcare.cbis.demo.data.entity.EAccount;

import com.cloudcare.common.lang.annotation.Label;

/**
 * AccountRepository is a Querydsl repository interface type
 */
@Label("Account存储")
public interface AccountRepository extends ModelQueryAndBatchUpdateRepository<Account, EAccount, Integer> {

}

