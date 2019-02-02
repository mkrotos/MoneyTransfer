package com.krotos.MoneyTransfer.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{number}")
    Account getByNumber(@PathVariable("number") long number) {
        return accountService.getByNumber(number);
    }

    @PostMapping("/create")
    Account add(@RequestBody Account account) {
        return accountService.add(account);
    }

    @DeleteMapping("/{number}")
    void delete(@PathVariable("number") long number) {
        accountService.delete(number);
    }

    @GetMapping("/{number}/balance")
    BigDecimal getBalance(@PathVariable("number") long number) {
        return accountService.getByNumber(number).getMoneys();
    }

    @PutMapping("/{number}/withdraw/{amount}")
    BigDecimal withdraw(@PathVariable("number") long number, @PathVariable("amount") BigDecimal amount) {
        return accountService.withdraw(number,amount);
    }

    @PutMapping("/{number}/deposit/{amount}")
    BigDecimal deposit(@PathVariable("number") long number, @PathVariable("amount") BigDecimal amount) {
        return accountService.deposit(number,amount);
    }


}
