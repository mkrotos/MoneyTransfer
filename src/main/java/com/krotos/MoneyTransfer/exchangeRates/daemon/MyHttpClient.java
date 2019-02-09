package com.krotos.MoneyTransfer.exchangeRates.daemon;

import org.springframework.web.client.RestTemplate;

class MyHttpClient {

    private RestTemplate restTemplate = new RestTemplate();

    void boo() {
        //todo zamienić na wczytywanie url z pliku properties
        String url = "https://api.exchangeratesapi.io/latest?base=USD";
        RatesResponseModel ratesResponseModel = restTemplate.getForObject(url, RatesResponseModel.class);
        System.out.println(ratesResponseModel);
    }
}
