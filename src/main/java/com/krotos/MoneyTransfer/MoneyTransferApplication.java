package com.krotos.MoneyTransfer;

import com.krotos.MoneyTransfer.exchangeRates.daemon.ExchangeRatesUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyTransferApplication implements CommandLineRunner {

    @Autowired
    private ExchangeRatesUpdater exchangeRatesUpdater;

    public static void main(String[] args) {
        SpringApplication.run(MoneyTransferApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        exchangeRatesUpdater.start(0, 5);
    }
}

