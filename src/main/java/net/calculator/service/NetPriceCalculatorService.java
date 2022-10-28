package net.calculator.service;

import net.calculator.model.CountryIso;

public interface NetPriceCalculatorService {
    Double calculateNetPrice(Double price, CountryIso countryIso);
    default Double calculateNetPrice(Integer price, CountryIso countryIso) {
        return calculateNetPrice(price.doubleValue(), countryIso);
    }
}
