package com.krotos.MoneyTransfer.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
class Account {
    @Id
    private long accountNumber;
    private BigDecimal moneys;
}
