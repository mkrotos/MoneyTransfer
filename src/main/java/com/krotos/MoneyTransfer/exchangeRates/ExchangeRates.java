package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

class ExchangeRates {
    private List<Rate> rates;

    ExchangeRates(List<Rate> rates) {
        this.rates = rates;
    }

    BigDecimal getUSDValue(Currency currency){
        return rates.stream().filter(r->r.getCurrency()==currency).findFirst().get().getUSDValue();
    }

    void updateRate(Currency currency, double usdValue){
        Optional<Rate> optionalRate = rates.stream().filter(r -> r.getCurrency() == currency).findFirst();
        optionalRate.get().setUSDValue(BigDecimal.valueOf(usdValue));
    }

    Iterator<Rate> getIterator(){
        return rates.iterator();
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "rates=" + rates +
                '}';
    }
}
