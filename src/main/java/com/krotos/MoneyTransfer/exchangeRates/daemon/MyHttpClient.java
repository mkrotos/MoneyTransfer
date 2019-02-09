package com.krotos.MoneyTransfer.exchangeRates.daemon;

import org.springframework.web.client.RestTemplate;

class MyHttpClient {

    private RestTemplate restTemplate = new RestTemplate();

    RatesResponseModel loadExternalRates() {
        //todo zamienić na wczytywanie url z pliku properties
        String url = "https://api.exchangeratesapi.io/latest?base=USD";
        return restTemplate.getForObject(url, RatesResponseModel.class);
    }
}
