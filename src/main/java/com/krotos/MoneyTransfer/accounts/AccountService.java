package com.krotos.MoneyTransfer.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AccountService {
    @Autowired
    private AccountDao accountDao;

    List<Account> getAll(){
        return accountDao.findAll();
    }

    Account getByNumber(long accountNumber){
        return accountDao.getOne(accountNumber);
    }

    Account add(Account account){
        return accountDao.save(account);
    }

    void delete(long id){
        accountDao.deleteById(id);
    }
}
