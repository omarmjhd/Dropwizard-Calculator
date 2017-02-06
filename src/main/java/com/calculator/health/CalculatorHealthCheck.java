package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.*;

public class CalculatorHealthCheck extends HealthCheck {

    private final CalculatorResource resource;

    public CalculatorHealthCheck(CalculatorResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.calculate("add", 1, 1).getResult() != 2) {
            return Result.unhealthy("CalculatorResource is not summing correctly");
        }

        if (resource.calculate("subtract", 2, 1).getResult() != 1) {
            return Result.unhealthy("CalculatorResource is not subtracting correctly");
        }

        if (resource.calculate("multiply", 5, 2).getResult() != 10) {
            return Result.unhealthy("CalculatorResource is not multiplying correctly");
        }

        if (resource.calculate("divide", 10, 2).getResult() != 5) {
            return Result.unhealthy("CalculatorResource is not dividing correctly");
        }

        if (resource.calculate("divide", 1, 0).getResult() != (1f / 0f)) {
            return Result.unhealthy("DivisionResource is not properly dividing by 0");
        }

        return Result.healthy();
    }
}