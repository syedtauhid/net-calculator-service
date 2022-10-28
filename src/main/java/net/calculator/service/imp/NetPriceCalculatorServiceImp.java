package net.calculator.service.imp;

import net.calculator.model.CountryIso;
import net.calculator.service.NetPriceCalculatorService;
import net.calculator.utility.TaxRateProvider;

import java.text.DecimalFormat;

import static net.calculator.config.Config.DEFAULT_DECIMAL_FORMAT;

public class NetPriceCalculatorServiceImp implements NetPriceCalculatorService {
    private final DecimalFormat decimalFormat;

    public NetPriceCalculatorServiceImp() {
        this.decimalFormat = new DecimalFormat(DEFAULT_DECIMAL_FORMAT);
    }

    @Override
    public Double calculateNetPrice(Double price, CountryIso countryIso) {
        Double taxRate = TaxRateProvider.getByCountry(countryIso);
        Double netPrice = price - (price * taxRate);
        return Double.valueOf(decimalFormat.format(netPrice));
    }
}
