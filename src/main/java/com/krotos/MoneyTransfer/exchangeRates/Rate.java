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
class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rateId;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @NonNull
    private BigDecimal USDValue;

    synchronized BigDecimal getUSDValue() {
        return USDValue;
    }

    synchronized void setUSDValue(BigDecimal USDValue) {
        this.USDValue = USDValue;
    }
}
