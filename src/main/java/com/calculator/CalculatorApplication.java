package com.calculator;

import com.calculator.health.CalculatorHealthCheck;
import com.calculator.modules.CalculatorModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        Injector injector = Guice.createInjector(new CalculatorModule(configuration));

        final CalculatorResource calculatorResource = injector.getInstance(CalculatorResource.class);

        final CalculatorHealthCheck calculatorHealthCheck = injector.getInstance(CalculatorHealthCheck.class);

        environment.healthChecks().register("Calc healthcheck", calculatorHealthCheck);
        environment.jersey().register(calculatorResource);


    }
}
