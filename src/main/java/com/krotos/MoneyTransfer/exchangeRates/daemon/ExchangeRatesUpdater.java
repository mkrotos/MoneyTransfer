package com.krotos.MoneyTransfer.exchangeRates.daemon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExchangeRatesUpdater {

    private MyHttpClient myHttpClient = new MyHttpClient();

    public void start(long period) {
        ScheduledExecutorService updater = Executors
                .newSingleThreadScheduledExecutor(DaemonFactory.produceDaemon("Rates Updater"));
        updater.scheduleAtFixedRate(updateRates(), 0, period, TimeUnit.MINUTES);
    }

    private Runnable updateRates() {
        return () -> {
            System.out.println("update");
            myHttpClient.boo();
        };
    }
}
