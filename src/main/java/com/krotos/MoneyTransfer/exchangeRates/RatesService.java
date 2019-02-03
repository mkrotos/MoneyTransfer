package com.krotos.MoneyTransfer.exchangeRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RatesService {
    private ExchangeRates exchangeRates;
    @Autowired
    private RateDao rateDao;

    private List<Rate> getAll(){
        return rateDao.findAll();
    }

    public ExchangeRates getExchangeRates(){
        if(exchangeRates==null){
            exchangeRates=new ExchangeRates(getAll());
        }
        return exchangeRates;
    }

    void saveToBase(){
        Iterator<Rate> iterator = exchangeRates.getIterator();
        while (iterator.hasNext()){
            rateDao.save(iterator.next());
        }
    }
}
