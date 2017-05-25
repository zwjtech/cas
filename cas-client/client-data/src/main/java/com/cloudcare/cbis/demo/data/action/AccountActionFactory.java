package com.cloudcare.cbis.demo.data.action;

import org.springframework.validation.annotation.Validated;
import com.cloudcare.data.api.DataAdminModule;
import com.cloudcare.cbis.demo.data.entity.EAccount;
import com.cloudcare.web.api.annotation.ParentModule;
import com.cloudcare.common.lang.annotation.Label;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloudcare.cbis.demo.data.model.Account;
import com.cloudcare.web.api.support.AbstractCrudModelActionFactory;
import org.springframework.stereotype.Controller;
import com.cloudcare.cbis.demo.data.repository.AccountRepository;

/**
 * AccountActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("Account数据管理")
@Validated({})
@Controller("AccountDataAdmin")
public class AccountActionFactory extends AbstractCrudModelActionFactory<AccountRepository, Account, EAccount, Integer> {

    @Autowired
    public AccountActionFactory(AccountRepository accountRepository) {
        super(accountRepository);
    }

}

