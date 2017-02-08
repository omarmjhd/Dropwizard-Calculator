package com.calculator.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultRepresentation { //POJO: plain old java object

    private Double result;
    private String operation;
    private Double value1;
    private Double value2;

    public ResultRepresentation() {
        //Jackson deserialization
    }

    public ResultRepresentation(Double result, String operation, Double value1, Double value2) {
        this.result = result;
        this.operation = operation;
        this.value1 = value1;
        this.value2 = value2;
    }

    @JsonProperty
    public Double getResult() {
        return result;
    }

    @JsonProperty
    public String getOperation() {
        return operation;
    }

    @JsonProperty
    public Double getValue1() {
        return value1;
    }

    @JsonProperty
    public Double getValue2() {
        return value2;
    }
}