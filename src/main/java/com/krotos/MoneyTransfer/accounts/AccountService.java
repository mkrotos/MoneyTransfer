package com.krotos.MoneyTransfer.accounts;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
class AccountService {
    @Autowired
    private AccountDao accountDao;

    List<Account> getAll() {
        return accountDao.findAll();
    }

    Account getByNumber(long accountNumber) {
        return accountDao.getOne(accountNumber);
    }

    Account add(Account account) {
        return accountDao.save(account);
    }

    void delete(long id) {
        accountDao.deleteById(id);
    }
    //todo przerobić na sql i oddelegować do bazy
    BigDecimal deposit(long id, BigDecimal moneys) {
        Account account = accountDao.getOne(id);
        @NonNull BigDecimal oldValue = account.getMoneys();
        BigDecimal newValue = oldValue.add(moneys);
        account.setMoneys(newValue);
        accountDao.save(account);
        return newValue;
    }

    BigDecimal withdraw(long id, BigDecimal moneys) {
        Account account = accountDao.getOne(id);
        @NonNull BigDecimal oldValue = account.getMoneys();
        BigDecimal newValue = oldValue.subtract(moneys);
        account.setMoneys(newValue);
        accountDao.save(account);
        return newValue;
    }
}
