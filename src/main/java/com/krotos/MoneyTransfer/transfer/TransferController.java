package com.krotos.MoneyTransfer.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchangeRates")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    void transfer(@RequestBody Transfer transfer) {
        System.out.println("Transfer");
        transferService.transfer(transfer);
    }
}
