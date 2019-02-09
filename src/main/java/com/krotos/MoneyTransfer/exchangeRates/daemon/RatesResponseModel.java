package com.krotos.MoneyTransfer.exchangeRates.daemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
class RatesResponseModel {
    private String base;
    private LocalDate date;
    private Map<String, Double> rates;
}
