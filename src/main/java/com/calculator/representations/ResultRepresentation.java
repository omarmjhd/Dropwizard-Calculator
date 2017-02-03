package com.calculator.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultRepresentation { //POJO: plain old java object

    private float result;
    private String operation;
    private float value1;
    private float value2;

    public ResultRepresentation() {
        //Jackson deserialization
    }

    public ResultRepresentation(float result, String operation, float value1, float value2) {
        this.result = result;
        this.operation = operation;
        this.value1 = value1;
        this.value2 = value2;
    }

    @JsonProperty
    public float getResult() {
        return result;
    }

    @JsonProperty
    public String getOperation() {
        return operation;
    }

    @JsonProperty
    public float getValue1() {
        return value1;
    }

    @JsonProperty
    public float getValue2() {
        return value2;
    }
}