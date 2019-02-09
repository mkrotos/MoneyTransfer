package com.krotos.MoneyTransfer.exchangeRates.daemon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ExchangeRatesUpdater {

    private Logger log = LogManager.getLogger(this.getClass());
    private MyHttpClient myHttpClient = new MyHttpClient();
    @Autowired
    private Updater updater;

    public void start(long delay, long period) {
        ScheduledExecutorService updater = Executors
                .newSingleThreadScheduledExecutor(DaemonFactory.produceDaemon("Rates Updater"));
        updater.scheduleAtFixedRate(updateRates(), delay, period, TimeUnit.MINUTES);
    }

    private Runnable updateRates() {
        return () -> {
            log.info("Rates update");
            RatesResponseModel externalRates = myHttpClient.loadExternalRates();
            log.info(externalRates);
            updater.updateAllRates(externalRates);
        };
    }
}
