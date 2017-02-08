package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.*;

import com.google.common.base.Optional;

public class CalculatorHealthCheck extends HealthCheck {

    private final CalculatorResource resource;

    public CalculatorHealthCheck(CalculatorResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {
        /*
        if (resource.calculate("add", new Optional<Double>(1.0).get(), new Optional<Double>(1.0).get()).getResult() != 2) {
            return Result.unhealthy("CalculatorResource is not summing correctly");
        }

        if (resource.calculate("subtract", new Optional<Double>(2.0).get(), new Optional<Double>(1.0).get()).getResult() != 1) {
            return Result.unhealthy("CalculatorResource is not subtracting correctly");
        }

        if (resource.calculate("multiply", new Optional<Double>(5.0).get(), new Optional<Double>(2.0).get()).getResult() != 10) {
            return Result.unhealthy("CalculatorResource is not multiplying correctly");
        }

        if (resource.calculate("divide", new Optional<Double>(0.0).get(), new Optional<Double>(2.0).get()).getResult() != 5) {
            return Result.unhealthy("CalculatorResource is not dividing correctly");
        }

        if (resource.calculate("divide", new Optional<Double>(1.0).get(), new Optional<Double>(0.0).get()).getResult() != (1f / 0f)) {
            return Result.unhealthy("DivisionResource is not properly dividing by 0");
        }

*/
        return Result.healthy();
    }
}
