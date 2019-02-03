package com.krotos.MoneyTransfer.transfer;

import com.krotos.MoneyTransfer.Currency;
import com.krotos.MoneyTransfer.exchangeRates.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchangeRates")
public class TransferController {

    @Autowired
    private RatesService ratesService;

    @PostMapping
    void transfer(){
        System.out.println(ratesService.getExchangeRates().getUSDValue(Currency.PLN));
    }
}
