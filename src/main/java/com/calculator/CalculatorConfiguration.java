package com.calculator;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotNull;

public class CalculatorConfiguration extends Configuration {

    @NotNull
    private Double defaultValue = -5.0;

    public Double getDefaultValue() {
        return defaultValue;

    }

}
