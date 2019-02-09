package com.krotos.MoneyTransfer;

import com.krotos.MoneyTransfer.exchangeRates.daemon.ExchangeRatesUpdater;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyTransferApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MoneyTransferApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExchangeRatesUpdater exchangeRatesUpdater = new ExchangeRatesUpdater();
        exchangeRatesUpdater.start();
    }
}

