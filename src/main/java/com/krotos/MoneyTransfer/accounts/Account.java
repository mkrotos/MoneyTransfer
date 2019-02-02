package com.krotos.MoneyTransfer.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "ACCOUNTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    @NonNull
    private BigDecimal moneys;

}
