package com.calculator.modules;

import com.calculator.CalculatorConfiguration;
import com.calculator.services.CalculatorService;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

import javax.inject.Named;

public class CalculatorModule implements Module{

    public void configure(Binder binder) {

    }

    @Provides
    @Named("calculator-service")
    public CalculatorService provideCalculator(CalculatorConfiguration calculatorConfiguration) {
        return new CalculatorService(calculatorConfiguration.getDefaultValue());
    }
}
