package com.calculator;

import com.calculator.health.CalculatorHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.calculator.resources.AdditionResource;
import com.calculator.resources.SubtractionResource;
import com.calculator.resources.MultiplicationResource;
import com.calculator.resources.DivisionResource;
import com.calculator.resources.CalculatorResource;

import com.calculator.health.AdditionHealthCheck;
import com.calculator.health.SubtractionHealthCheck;
import com.calculator.health.MultiplicationHealthCheck;
import com.calculator.health.DivisionHealthCheck;

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
        //nothing yet
    }

    @Override
    public void run(CalculatorConfiguration configuration, Environment environment) {


        final CalculatorResource calculatorResource = new CalculatorResource(configuration.getCalculatorService());

        final CalculatorHealthCheck calculatorHealthCheck = new CalculatorHealthCheck(calculatorResource);

        environment.healthChecks().register("Calc healthcheck", calculatorHealthCheck);
        environment.jersey().register(calculatorResource);

        /*final AdditionResource additionResource = new AdditionResource();
        final SubtractionResource subtractionResource = new SubtractionResource();
        final MultiplicationResource multiplicationResource = new MultiplicationResource();
        final DivisionResource divisionResource = new DivisionResource();
        final CalculatorResource calculatorResource = new CalculatorResource();

        final AdditionHealthCheck additionHealthCheck = new AdditionHealthCheck(additionResource);
        environment.healthChecks().register("Addition HealthCheck", additionHealthCheck);

        final SubtractionHealthCheck subtractionHealthCheck = new SubtractionHealthCheck(subtractionResource);
        environment.healthChecks().register("Subtraction HealthCheck", subtractionHealthCheck);

        final MultiplicationHealthCheck multiplicationHealthCheck = new MultiplicationHealthCheck(multiplicationResource);
        environment.healthChecks().register("Multiplication HealthCheck", multiplicationHealthCheck);

        final DivisionHealthCheck divisionHealthCheck = new DivisionHealthCheck(divisionResource);
        environment.healthChecks().register("Division HealthCheck", divisionHealthCheck);

        final CalculatorHealthCheck calculatorHealthCheck = new CalculatorHealthCheck(calculatorResource);
        environment.healthChecks().register("Calculator HealthCheck", calculatorHealthCheck);

        environment.jersey().register(additionResource);
        environment.jersey().register(subtractionResource);
        environment.jersey().register(multiplicationResource);
        environment.jersey().register(divisionResource);
        environment.jersey().register(calculatorResource);
        */


    }
}
