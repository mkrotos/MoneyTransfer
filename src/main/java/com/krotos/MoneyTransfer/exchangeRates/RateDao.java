package com.krotos.MoneyTransfer.exchangeRates;

import com.krotos.MoneyTransfer.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface RateDao extends JpaRepository<Rate, Long> {

    Optional<Rate> findByCurrency(Currency currency);
}
