package com.calculator.health;

import com.calculator.interfaces.CalculatorServiceInterface;
import com.codahale.metrics.health.HealthCheck;
import com.calculator.services.*;
import com.google.common.base.Optional;
import com.google.inject.Inject;

public class CalculatorHealthCheck extends HealthCheck {

    private final CalculatorServiceInterface service;

    @Inject
    public CalculatorHealthCheck(CalculatorServiceInterface service) {
        this.service = service;
    }

    @Override
    protected Result check() throws Exception {

        if (service.calculate("add", Optional.of(1.0), Optional.of(1.0)).getResult() != 2) {
            return Result.unhealthy("Calculatorservice is not summing correctly");
        }

        if (service.calculate("subtract", Optional.of(2.0), Optional.of(1.0)).getResult() != 1) {
            return Result.unhealthy("Calculatorservice is not subtracting correctly");
        }

        if (service.calculate("multiply", Optional.of(5.0), Optional.of(2.0)).getResult() != 10) {
            return Result.unhealthy("Calculatorservice is not multiplying correctly");
        }

        if (service.calculate("divide", Optional.of(10.0), Optional.of(2.0)).getResult() != 5) {
            return Result.unhealthy("Calculatorservice is not dividing correctly");
        }

        if (!Double.isNaN(service.calculate("divide", Optional.of(0.0), Optional.of(0.0)).getResult())) {
            return Result.unhealthy("Divisionservice is not properly dividing 0 by 0");
        }

        if (!Double.isInfinite(service.calculate("divide", Optional.of(1.0), Optional.of(0.0)).getResult())) {
            return Result.unhealthy("Divisionservice is not properly returning Infinity");
        }

        return Result.healthy();
    }
}
