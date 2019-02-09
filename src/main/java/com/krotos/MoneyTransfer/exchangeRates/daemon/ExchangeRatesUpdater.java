package com.krotos.MoneyTransfer.exchangeRates.daemon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExchangeRatesUpdater {

    public void start() {
        ScheduledExecutorService updater = Executors.newSingleThreadScheduledExecutor(DaemonFactory.produceDaemon("Rates Updater"));
        updater.scheduleAtFixedRate(updateRates(),0,15, TimeUnit.SECONDS);
    }

    private Runnable updateRates(){
        return () -> System.out.println("update");
    }
}
