package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.DivisionResource;

public class DivisionHealthCheck extends HealthCheck {

    private final DivisionResource resource;

    public DivisionHealthCheck(DivisionResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.divideValues(20, 4).getResult() != 5) {
            return Result.unhealthy("DivisionResource is not dividing correctly");
        }

        if (!resource.divideValues(1, 1).getOperation().equals("/")) {
            return Result.unhealthy("DivisionResource Operation is wrong");
        }

        if (resource.divideValues(1, 0).getResult() != (1f / 0f)) {
            return Result.unhealthy("DivisionResource is not properly dividing by 0");
        }

        return Result.healthy();
    }
}
