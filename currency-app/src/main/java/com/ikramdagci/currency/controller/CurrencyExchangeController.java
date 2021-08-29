package com.ikramdagci.currency.controller;


import com.ikramdagci.currency.model.Currency;
import com.ikramdagci.currency.service.CurrencyExchangeService;
import com.sun.xml.bind.v2.TODO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Data
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/exchange/{from}/{to}")
    public double exchange(@PathVariable String from, @PathVariable String to) {
        return currencyExchangeService.exchange(Currency.USD,Currency.TRY);
    }


}
