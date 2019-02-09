package com.krotos.MoneyTransfer.transfer;

import com.krotos.MoneyTransfer.Currency;
import com.krotos.MoneyTransfer.accounts.Account;
import com.krotos.MoneyTransfer.accounts.AccountService;
import com.krotos.MoneyTransfer.exchangeRates.RatesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
class TransferService {
    @Autowired
    private TransferDao transferDao;
    @Autowired
    private RatesService ratesService;
    @Autowired
    private AccountService accountService;

    private Logger log = LogManager.getLogger(this.getClass());

    void transfer(Transfer transfer) {
        log.info(transfer);
        Account fromAccount = accountService.getByNumber(transfer.getFromAccountNumber());
        Account toAccount = accountService.getByNumber(transfer.getToAccountNumber());

        Currency fromCurrency = fromAccount.getCurrency();
        Currency inCurrency = transfer.getCurrency();
        Currency toCurrency = toAccount.getCurrency();
        BigDecimal initialValue = transfer.getAmount();

        if (fromCurrency == toCurrency && fromCurrency == inCurrency) {
            accountService.withdraw(transfer.getToAccountNumber(), initialValue);
            accountService.deposit(transfer.getToAccountNumber(), initialValue);
        } else {
            BigDecimal usdValue = initialValue.multiply(ratesService.getUSDValue(inCurrency));
            BigDecimal valueToDeposit = usdValue.divide(ratesService.getUSDValue(toCurrency), RoundingMode.HALF_UP);
            BigDecimal valueToWithdraw = usdValue.divide(ratesService.getUSDValue(fromCurrency),RoundingMode.HALF_UP);

            accountService.withdraw(transfer.getFromAccountNumber(),valueToWithdraw);
            accountService.deposit(transfer.getToAccountNumber(),valueToDeposit);
        }

        saveToDB(transfer);
    }

    private Transfer saveToDB(Transfer transfer) {
        return transferDao.save(transfer);
    }
}
