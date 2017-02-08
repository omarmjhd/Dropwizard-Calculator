package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.*;
import com.google.inject.Inject;

public class CalculatorHealthCheck extends HealthCheck {

    private final CalculatorResource resource;

    @Inject
    public CalculatorHealthCheck(CalculatorResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.calculate("add", 1.0, 1.0).getResult() != 2) {
            return Result.unhealthy("CalculatorResource is not summing correctly");
        }

        if (resource.calculate("subtract", 2.0, 1.0).getResult() != 1) {
            return Result.unhealthy("CalculatorResource is not subtracting correctly");
        }

        if (resource.calculate("multiply", 5.0, 2.0).getResult() != 10) {
            return Result.unhealthy("CalculatorResource is not multiplying correctly");
        }

        if (resource.calculate("divide", 10.0, 2.0).getResult() != 5) {
            return Result.unhealthy("CalculatorResource is not dividing correctly");
        }

        if (!Double.isNaN(resource.calculate("divide", 0.0, 0.0).getResult())) {
            return Result.unhealthy("DivisionResource is not properly dividing 0 by 0");
        }

        if (!Double.isInfinite(resource.calculate("divide", 1.0, 0.0).getResult())) {
            return Result.unhealthy("DivisionResource is not properly returning Infinity");
        }

        return Result.healthy();
    }
}
