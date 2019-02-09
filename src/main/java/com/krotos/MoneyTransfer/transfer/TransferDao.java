package com.krotos.MoneyTransfer.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TransferDao extends JpaRepository<Transfer, Long> {
}
