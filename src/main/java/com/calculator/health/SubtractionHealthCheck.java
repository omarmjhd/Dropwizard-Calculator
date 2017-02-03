package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.SubtractionResource;

public class SubtractionHealthCheck extends HealthCheck {

    private final SubtractionResource resource;

    public SubtractionHealthCheck(SubtractionResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.subtractValues(1, 1).getResult() != 0) {
            return Result.unhealthy("SubtractionResource is not subtracting correctly");
        }

        if (!resource.subtractValues(1, 1).getOperation().equals("-")) {
            return Result.unhealthy("AdditionResource Operation is wrong");
        }

        return Result.healthy();
    }
}
