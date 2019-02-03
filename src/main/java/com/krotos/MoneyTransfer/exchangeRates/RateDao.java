package com.krotos.MoneyTransfer.exchangeRates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RateDao extends JpaRepository<Rate, Long> {
}
