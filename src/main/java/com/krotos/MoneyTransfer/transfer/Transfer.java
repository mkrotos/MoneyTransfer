package com.krotos.MoneyTransfer.transfer;

import com.krotos.MoneyTransfer.Currency;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "TRANSFERS")
@Entity
class Transfer {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private long fromAccountNumber;
    @NonNull
    private long toAccountNumber;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @NonNull
    private BigDecimal amount;
}
