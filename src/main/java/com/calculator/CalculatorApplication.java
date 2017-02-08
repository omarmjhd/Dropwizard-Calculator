package com.calculator;

import com.calculator.health.CalculatorHealthCheck;
import com.calculator.modules.CalculatorHealthCheckModule;
import com.calculator.modules.CalculatorModule;
import com.calculator.services.CalculatorService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.calculator.resources.CalculatorResource;


public class CalculatorApplication extends Application<CalculatorConfiguration> {

    public static void main(String[] args) throws Exception {
        new CalculatorApplication().run(args);
    }

    @Override
    public String getName() {
        return "calculator";
    }

    @Override
    public void initialize(Bootstrap<CalculatorConfiguration> bootstrap) {
    }

    @Override
    public void run(CalculatorConfiguration configuration, Environment environment) throws Exception {


        Injector injector = Guice.createInjector(new CalculatorModule(configuration), new CalculatorHealthCheckModule(configuration));

        final CalculatorResource calculatorResource = injector.getInstance(CalculatorResource.class);

        final CalculatorHealthCheck calculatorHealthCheck = injector.getInstance(CalculatorHealthCheck.class);

        environment.healthChecks().register("Calc healthcheck", calculatorHealthCheck);
        environment.jersey().register(calculatorResource);


    }
}
