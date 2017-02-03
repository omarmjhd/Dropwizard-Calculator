package com.calculator.health;

import com.codahale.metrics.health.HealthCheck;
import com.calculator.resources.MultiplicationResource;

public class MultiplicationHealthCheck extends HealthCheck {

    private final MultiplicationResource resource;

    public MultiplicationHealthCheck(MultiplicationResource resource) {
        this.resource = resource;
    }

    @Override
    protected Result check() throws Exception {

        if (resource.multiplyValues(5, 5).getResult() != 1) {
            return Result.unhealthy("MultiplicationResource is not summing correctly");
        }

        if (!resource.multiplyValues(1, 1).getOperation().equals("*")) {
            return Result.unhealthy("MultiplicationResource Operation is wrong");
        }

        return Result.healthy();
    }
}
