package com.krotos.MoneyTransfer.exchangeRates.daemon;

import com.krotos.MoneyTransfer.Currency;
import com.krotos.MoneyTransfer.exchangeRates.RatesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class Updater {
    @Autowired
    private RatesService ratesService;
    private Logger log = LogManager.getLogger(this.getClass());

    void updateAllRates(RatesResponseModel ratesResponseModel) {
        Map<String, Double> newRates = ratesResponseModel.getRates();
        for (Currency currency : Currency.values()) {
            updateRateIfExists(newRates, currency);
        }
    }

    private void updateRateIfExists(Map<String, Double> rates, Currency currency) {
        if (!rates.containsKey(currency.toString())) {
            log.info(String.format("Nie znaleziono przelicznika %s w pobranych danych", currency));
            return;
        }
        Double rate = rates.get(currency.toString());
        updateSingleRate(currency, rate);
    }

    private void updateSingleRate(Currency currency, Double rate) {
        double usdValue = 1 / rate;
        ratesService.updateRate(currency, usdValue);
    }
}
