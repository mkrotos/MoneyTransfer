package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXCHANGE_RATES")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rateId;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @NonNull
    private BigDecimal USDValue;

}