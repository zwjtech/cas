package com.cloudcare.demo.biz.service.impl;

import com.cloudcare.common.lang.LocaleBizServiceException;
import com.cloudcare.demo.biz.service.UserService;
import com.cloudcare.cbis.demo.data.model.Account;
import com.cloudcare.cbis.demo.data.repository.AccountRepository;
import com.cloudcare.cbis.demo.face.domain.UserRegisterForm;
import com.cloudcare.common.lang.security.PasswordHelper;
import com.cloudcare.common.lang.service.AbstractBaseService;
import com.cloudcare.data.api.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

/**
 * Created by ASUS on 2017/5/12.
 */
@Service
public class DefaultUserService extends AbstractBaseService implements UserService {


    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account userRegister(UserRegisterForm demoRegisterForm) {
        Account account=accountRepository.findOneByModel(Filter.condition().equal("name",demoRegisterForm.getUsername()));

        if (nonNull(account)){
            throw new LocaleBizServiceException("User.Account.AlreadyExist");
        }

        Account model=new Account();
        model.setName(demoRegisterForm.getUsername());
        model.setPassword(PasswordHelper.encryption(demoRegisterForm.getPassword()));

        model=accountRepository.createModel(model);

        return model;
    }

    public boolean checkUser(String username, String password) {
        Account account=accountRepository.findOneByModel(Filter.condition().equal("name",username));
        if(null==account){
            return false;
        }

        return PasswordHelper.encryption(password).equals(account.getPassword());
    }


}
