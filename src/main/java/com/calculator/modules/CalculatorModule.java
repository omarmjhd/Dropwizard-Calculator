package com.calculator.modules;

import com.calculator.CalculatorConfiguration;
import com.calculator.resources.CalculatorResource;
import com.calculator.services.CalculatorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import javax.inject.Named;

public class CalculatorModule extends AbstractModule {

    private CalculatorConfiguration configuration;

    @Override
    public void configure() {
        //configure the parts needed for a CalculatorModule
        //double named default double that we'll assign somehow
        bindConstant().annotatedWith(Names.named("defaultDouble")).to(configuration.getDefaultValue()); //going to calculator service, saying I need defValue, getting it from config and preparing it
        bind(CalculatorService.class);

    }

    public CalculatorModule(CalculatorConfiguration configuration) {
        this.configuration = configuration;
    }

}
