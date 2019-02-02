package com.krotos.MoneyTransfer.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountDao extends JpaRepository<Account,Long> {
}
