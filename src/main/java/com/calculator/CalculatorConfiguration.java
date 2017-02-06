package com.calculator;

import com.calculator.services.CalculatorService;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotNull;

public class CalculatorConfiguration extends Configuration {

    @NotNull
    private CalculatorService calculatorService = new CalculatorService();

    @JsonProperty
    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    @JsonProperty
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

}
