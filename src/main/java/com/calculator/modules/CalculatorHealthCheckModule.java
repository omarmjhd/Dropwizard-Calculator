package com.calculator.modules;

import com.calculator.CalculatorConfiguration;
import com.calculator.resources.CalculatorResource;
import com.calculator.services.CalculatorService;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class CalculatorHealthCheckModule extends AbstractModule {

    private CalculatorConfiguration configuration;

    @Override
    public void configure() {
        //configure the parts needed for a CalculatorModule
        //double named default double that we'll assign somehow
        bindConstant().annotatedWith(Names.named("defaultDouble")).to(configuration.getDefaultValue()); //going to calculator service, saying I need defValue, getting it from config and preparing it
        bind(CalculatorService.class);
        bind(CalculatorResource.class);

    }

    public CalculatorHealthCheckModule(CalculatorConfiguration configuration) {
        this.configuration = configuration;
    }

}
