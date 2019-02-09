package com.krotos.MoneyTransfer.accounts;

import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;
    private Logger log= LogManager.getLogger(this.getClass());

    List<Account> getAll() {
        return accountDao.findAll();
    }

    public Account getByNumber(long accountNumber) {
        return accountDao.getOne(accountNumber);
    }

    Account add(Account account) {
        Account saved = accountDao.save(account);
        log.info("Dodawanie konta "+saved);
        return saved;
    }

    void delete(long number) {
        accountDao.deleteById(number);
        log.info("Usunięto konto o numerze "+number);
    }
    //todo przerobić na sql i oddelegować do bazy
    public BigDecimal deposit(long numer, BigDecimal amount) {
        Account account = accountDao.getOne(numer);
        @NonNull BigDecimal oldValue = account.getMoneys();
        BigDecimal newValue = oldValue.add(amount);
        account.setMoneys(newValue);
        accountDao.save(account);

        log.info(String.format( "Depozyt na konto: %016d kwota: %.2f stara wartość: %.2f nowa wartość: %.2f %s",
                numer,amount,oldValue,newValue,account.getCurrency()));
        return newValue;
    }

    public BigDecimal withdraw(long numer, BigDecimal amount) {
        Account account = accountDao.getOne(numer);
        @NonNull BigDecimal oldValue = account.getMoneys();
        BigDecimal newValue = oldValue.subtract(amount);
        account.setMoneys(newValue);
        accountDao.save(account);

        log.info(String.format( "Wyciąg z konta: %016d kwota: %.2f stara wartość: %.2f nowa wartość: %.2f %s",
                numer,amount,oldValue,newValue,account.getCurrency()));
        return newValue;
    }
}
