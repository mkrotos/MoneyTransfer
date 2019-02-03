package com.krotos.MoneyTransfer;

public enum Currency {
    USD,
    PLN,
    GBP,
    EUR;

    @Override
    public String toString() {
        return this.name();
    }
}
