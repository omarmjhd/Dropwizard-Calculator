package com.calculator.services;

import com.calculator.interfaces.CalculatorServiceInterface;
import com.calculator.representations.ResultRepresentation;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class CalculatorService implements CalculatorServiceInterface {

    private Double defaultValue;

    @Inject
    public CalculatorService(@Named("defaultDouble") Double defaultValue) {
        this.defaultValue = defaultValue;

    }

    public ResultRepresentation calculate(String operation, Optional<Double> value1, Optional<Double> value2) {


        if (operation.equals("add")) {
            return addValues(value1.or(defaultValue), value2.or(defaultValue));
        } else if (operation.equals("subtract")) {
            return subtractValues(value1.or(defaultValue), value2.or(defaultValue));
        } else if (operation.equals("multiply")) {
            return multiplyValues(value1.or(defaultValue), value2.or(defaultValue));
        } else if (operation.equals("divide")) {
            return divideValues(value1.or(defaultValue), value2.or(defaultValue));
        }
        else {
            return new ResultRepresentation(0.0, "Error: " + operation + " operation not found", value1.or(defaultValue), value2.or(defaultValue));
        }
    }

    private ResultRepresentation addValues(Double value1, Double value2) {

        final Double sum = value1 + value2;

        return new ResultRepresentation(sum, "add", value1, value2);
    }

    private ResultRepresentation subtractValues(Double value1, Double value2) {

        final Double difference = value1 - value2;

        return new ResultRepresentation(difference, "subtract", value1, value2);
    }

    private ResultRepresentation multiplyValues(Double value1, Double value2) {

        final Double product = value1 * value2;

        return new ResultRepresentation(product, "multiply", value1, value2);
    }

    private ResultRepresentation divideValues(Double value1, Double value2) {

        final Double quotient = value1 / value2;

        return new ResultRepresentation(quotient, "divide", value1, value2);
    }


}
