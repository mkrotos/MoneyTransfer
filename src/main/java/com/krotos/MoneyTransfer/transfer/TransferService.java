package com.krotos.MoneyTransfer.transfer;

import com.krotos.MoneyTransfer.exchangeRates.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TransferService {
    @Autowired
    private TransferDao transferDao;
    @Autowired
    private RatesService ratesService;

    void transfer(Transfer transfer){
        System.out.println(transfer);


    }
}
