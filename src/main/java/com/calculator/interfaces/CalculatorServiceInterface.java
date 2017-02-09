package com.calculator.interfaces;

import com.calculator.representations.ResultRepresentation;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

public interface CalculatorServiceInterface {

    ResultRepresentation calculate(String operation, Optional<Double> value1, Optional<Double> value2);

}
