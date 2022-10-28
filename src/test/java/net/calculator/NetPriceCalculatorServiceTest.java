package net.calculator;

import net.calculator.service.NetPriceCalculatorService;
import net.calculator.service.imp.NetPriceCalculatorServiceImp;
import net.calculator.utility.TaxRateProvider;
import org.junit.jupiter.api.Test;

import static net.calculator.config.Config.DEFAULT_DECIMAL_FORMATTER;
import static net.calculator.model.CountryIso.DE;
import static net.calculator.model.CountryIso.FR;
import static org.junit.jupiter.api.Assertions.*;

public class NetPriceCalculatorServiceTest {
  NetPriceCalculatorService service;

  NetPriceCalculatorServiceTest() {
    service = new NetPriceCalculatorServiceImp();
  }

  @Test
  void calculateNetPrice() {
    double netPrice = service.calculateNetPrice(100, DE);
    double expectedNetPrice = 100 - (100 * TaxRateProvider.getByCountry(DE));
    assertEquals(expectedNetPrice, netPrice);

    netPrice = service.calculateNetPrice(100, FR);
    expectedNetPrice = 100 - (100 * TaxRateProvider.getByCountry(FR));
    assertEquals(expectedNetPrice, netPrice);
  }

  @Test
  void calculateNetPriceWithDecimal() {
    double netPrice = service.calculateNetPrice(2.99, DE);
    double expectedNetPrice = Double.parseDouble(
        DEFAULT_DECIMAL_FORMATTER.format(2.99 - (2.99 * TaxRateProvider.getByCountry(DE)))
    );
    assertEquals(expectedNetPrice, netPrice);

    netPrice = service.calculateNetPrice(5.55, FR);
    expectedNetPrice = Double.parseDouble(
        DEFAULT_DECIMAL_FORMATTER.format(5.55 - (5.55 * TaxRateProvider.getByCountry(FR)))
    );
    assertEquals(expectedNetPrice, netPrice);
  }
}
