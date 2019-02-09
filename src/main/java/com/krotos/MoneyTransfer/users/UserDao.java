package com.krotos.MoneyTransfer.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
