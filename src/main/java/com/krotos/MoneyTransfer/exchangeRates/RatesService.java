package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    private ExchangeRates getExchangeRates(){
        if(exchangeRates==null){
            exchangeRates=new ExchangeRates(getAll());
        }
        return exchangeRates;
    }

    public BigDecimal getUSDValue(Currency currency){
        return getExchangeRates().getUSDValue(currency);
    }

    //todo dodać klienta do pobierania kursów z innego servisu, odświerzanie co 15 min

    void saveToBase(){
        Iterator<Rate> iterator = exchangeRates.getIterator();
        while (iterator.hasNext()){
            rateDao.save(iterator.next());
        }
    }
}
