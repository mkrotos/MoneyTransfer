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
        transferMoneys(transfer);
        saveToDB(transfer);
    }

    private void transferMoneys(Transfer transfer) {
        Account fromAccount = accountService.getByNumber(transfer.getFromAccountNumber());
        Account toAccount = accountService.getByNumber(transfer.getToAccountNumber());

        Currency fromCurrency = fromAccount.getCurrency();
        Currency inCurrency = transfer.getCurrency();
        Currency toCurrency = toAccount.getCurrency();
        BigDecimal initialValue = transfer.getAmount();

        if (fromCurrency == toCurrency && fromCurrency == inCurrency) {
            transferWithoutConversion(transfer);
        } else {
            transferWithConversion(transfer, fromCurrency, inCurrency, toCurrency, initialValue);
        }
    }

    private void transferWithoutConversion(Transfer transfer) {
        BigDecimal initialValue = transfer.getAmount();
        transferConvertedValues(transfer, initialValue, initialValue);
    }

    private void transferWithConversion(Transfer transfer, Currency fromCurrency, Currency inCurrency,
                                        Currency toCurrency, BigDecimal initialValue) {
        BigDecimal usdValue = toUSDValue(inCurrency, initialValue);
        BigDecimal valueToDeposit = fromUSDValue(toCurrency, usdValue);
        BigDecimal valueToWithdraw = fromUSDValue(fromCurrency, usdValue);

        transferConvertedValues(transfer, valueToDeposit, valueToWithdraw);
    }

    private BigDecimal fromUSDValue(Currency toCurrency, BigDecimal usdValue) {
        return usdValue.divide(ratesService.getUSDValue(toCurrency), RoundingMode.HALF_UP);
    }

    private BigDecimal toUSDValue(Currency inCurrency, BigDecimal initialValue) {
        return initialValue.multiply(ratesService.getUSDValue(inCurrency));
    }

    private void transferConvertedValues(Transfer transfer, BigDecimal valueToDeposit, BigDecimal valueToWithdraw) {
        accountService.withdraw(transfer.getFromAccountNumber(), valueToWithdraw);
        accountService.deposit(transfer.getToAccountNumber(), valueToDeposit);
    }

    private void saveToDB(Transfer transfer) {
        transferDao.save(transfer);
    }
}
