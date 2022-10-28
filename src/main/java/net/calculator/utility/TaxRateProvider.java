package net.calculator.utility;

import net.calculator.model.CountryIso;

import java.util.Map;

public class TaxRateProvider {
    private static final Map<CountryIso, Double> taxRateMap = Map.of(
        CountryIso.DE, 0.19,
        CountryIso.NL, 0.18,
        CountryIso.IT, 0.16,
        CountryIso.FR, 0.20
    );

    public static Double getByCountry(CountryIso countryIso) {
        return taxRateMap.get(countryIso);
    }

}
