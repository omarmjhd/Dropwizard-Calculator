package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.AdditionResource;

public class AdditionHealthCheck extends HealthCheck {

    private final AdditionResource resource;

    public AdditionHealthCheck(AdditionResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.addValues(1, 1).getResult() != 2) {
            return Result.unhealthy("AdditionResource is not summing correctly");
        }

        if (!resource.addValues(1, 1).getOperation().equals("+")) {
            return Result.unhealthy("AdditionResource Operation is wrong");
        }

        return Result.healthy();
    }
}
