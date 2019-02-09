package com.krotos.MoneyTransfer.exchangeRates.daemon;

import java.util.concurrent.ThreadFactory;

class DaemonFactory {
    static ThreadFactory produceDaemon(String name){
        return runnable -> {
            Thread thread = new Thread(runnable, name);
            thread.setDaemon(true);
            return thread;
        };
    }
}
