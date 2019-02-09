package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RatesService {
    private ExchangeRates exchangeRates;
    @Autowired
    private RateDao rateDao;

    private List<Rate> getAll() {
        return rateDao.findAll();
    }

    private ExchangeRates getExchangeRates() {
        if (exchangeRates == null) {
            exchangeRates = new ExchangeRates(getAll());
        }
        return exchangeRates;
    }

    public BigDecimal getUSDValue(Currency currency) {
        return getExchangeRates().getUSDValue(currency);
    }

    public void updateRate(Currency currency, double usdValue) {
        getExchangeRates().updateRate(currency, usdValue);
        saveRateToBase(currency, usdValue);
    }

    private void saveRateToBase(Currency currency, double usdValue) {
        Rate rateFromBase = getRateFromBase(currency);
        rateFromBase.setUSDValue(BigDecimal.valueOf(usdValue));
        rateDao.save(rateFromBase);
    }

    private Rate getRateFromBase(Currency currency) {
        return rateDao.findByCurrency(currency).orElse(new Rate(currency, BigDecimal.ZERO));
    }
}
