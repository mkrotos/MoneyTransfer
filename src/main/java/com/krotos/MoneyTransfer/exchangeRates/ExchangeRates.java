package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@ToString
class ExchangeRates {
    private List<Rate> rates;

    ExchangeRates(List<Rate> rates) {
        this.rates = rates;
    }

    BigDecimal getUSDValue(Currency currency) {
        return rates.stream().filter(r -> r.getCurrency() == currency).findFirst().get().getUSDValue();
    }

    void updateRate(Currency currency, double usdValue) {
        rates.stream().filter(r -> r.getCurrency() == currency)
                .findFirst().get()
                .setUSDValue(BigDecimal.valueOf(usdValue));
    }
}
