package com.web.product;

import com.web.product.exceptions.InvalidPriceException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Price {

    private final BigDecimal value;
    private final Currency currency;

    public Price(BigDecimal value, Currency currency) {
        if (isPriceValueNegative(value)) {
            throw new InvalidPriceException("Price can't be negative, but set: " + value);
        }

        this.value = value;
        this.currency = currency;
    }

    private boolean isPriceValueNegative(BigDecimal value) {
        return value.signum() < 0;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Price convertTo(Currency targetCurrency) {
        BigDecimal conversionRate = currency.getConversionRate(targetCurrency);
        BigDecimal convertedValue = value.multiply(conversionRate)
            .setScale(targetCurrency.getFractionDigits(), RoundingMode.HALF_UP);

        return new Price(convertedValue, targetCurrency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return Objects.equals(value, price.value) && currency == price.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Price{"
            + "value=" + value
            + ", currency=" + currency
            + '}';
    }
}