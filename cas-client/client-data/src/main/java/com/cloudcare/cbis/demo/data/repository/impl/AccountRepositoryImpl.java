package com.cloudcare.cbis.demo.data.repository.impl;

import com.cloudcare.data.querydsl.support.AbstractModelQueryAndBatchUpdateRepository;

import com.cloudcare.cbis.demo.data.entity.EAccount;

import com.cloudcare.cbis.demo.data.model.Account;

import com.cloudcare.cbis.demo.data.repository.AccountRepository;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.common.lang.annotation.Label;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * AccountRepositoryImpl is a Querydsl repository implement type
 */
@Label("Account存储实现")
@Validated({})
@Repository("accountRepository")
public class AccountRepositoryImpl extends AbstractModelQueryAndBatchUpdateRepository<EAccount, Integer, Account> implements AccountRepository {

    @Autowired
    public AccountRepositoryImpl(DataSource dataSource) {
    	super(dataSource);
    }
    
}

