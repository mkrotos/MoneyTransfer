package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;

import java.util.Iterator;
import java.util.List;

public class ExchangeRates {
    private List<Rate> rates;

    ExchangeRates(List<Rate> rates) {
        this.rates = rates;
    }

    public double getUSDValue(Currency currency){
        return rates.stream().filter(r->r.getCurrency()==currency).findFirst().get().getUSDValue();
    }

    void updateRate(Currency currency, double usdValue){
        rates.stream().filter(r->r.getCurrency()==currency).findFirst().get().setUSDValue(usdValue);
    }

    Iterator<Rate> getIterator(){
        return rates.iterator();
    }
}
