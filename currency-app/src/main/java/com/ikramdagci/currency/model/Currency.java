package com.ikramdagci.currency.model;

public enum Currency {
    TRY("Türk Lirası","₺"),
    USD("Amerikan Doları","$"),
    EUR("Euro","€"),
    GBP("İngiliz Pound","£");


    private String currencyName;
    private String currencySign;

    Currency(String currencyName, String currencySign) {
        this.currencyName = currencyName;
        this.currencySign = currencySign;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySign() {
        return currencySign;
    }

    public Currency getCurrencyFromName(String name) {
      /**
        switch (name) {
            case (Currency.TRY.getCurrencyName()):
                return Currency.TRY;
            case (Currency.EUR.getCurrencyName()):
                return Currency.EUR;
            case (Currency.USD.getCurrencyName()):
                return Currency.USD;
            case (Currency.GBP.getCurrencyName()):
                return Currency.GBP;
        }
        */
        return null;
    }
}
