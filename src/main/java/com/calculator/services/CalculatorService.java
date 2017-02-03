package com.calculator.services;

import com.calculator.api.ResultRepresentation;

public class CalculatorService {

    public CalculatorService() { //no-arg constructor to create the service

    }

    public ResultRepresentation calculate(String operation, float value1, float value2) {

        if (operation.equals("add")) {
            return addValues(value1, value2);
        } else if (operation.equals("subtract")) {
            return subtractValues(value1, value2);
        } else if (operation.equals("multiply")) {
            return multiplyValues(value1, value2);
        } else if (operation.equals("divide")) {
            return divideValues(value1, value2);
        } else {
            return new ResultRepresentation(0, "Error: " + operation + " operation not found", value1, value2);
        }
    }

    private ResultRepresentation addValues(float value1, float value2) {

        final float sum = value1 + value2;

        return new ResultRepresentation(sum, "add", value1, value2);
    }

    private ResultRepresentation subtractValues(float value1, float value2) {

        final float difference = value1 - value2;

        return new ResultRepresentation(difference, "subtract", value1, value2);
    }

    private ResultRepresentation multiplyValues(float value1, float value2) {

        final float product = value1 * value2;

        return new ResultRepresentation(product, "multiply", value1, value2);
    }

    private ResultRepresentation divideValues(float value1, float value2) {

        final float quotient = value1 / value2;

        return new ResultRepresentation(quotient, "divide", value1, value2);
    }


}
