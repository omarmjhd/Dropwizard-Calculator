package com.calculator.resources;


import com.calculator.representations.ResultRepresentation;
import com.calculator.services.CalculatorService;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("calculator")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class CalculatorResource {

    private final CalculatorService calculatorService;

    @Inject
    public CalculatorResource(CalculatorService calculatorService) { //According to Milo, this Resource shouldnt be driving the operations, but rather just connect to a service that interfaces with a DB or something of the like to pull a result
        this.calculatorService = calculatorService;
    }

    @GET
    @Timed
    public ResultRepresentation calculate(@QueryParam("operation") String operation, @QueryParam("value1") Double value1, @QueryParam("value2") Double value2) { //@QueryParam("name") maps the name field in the query to name object in param

        return calculatorService.calculate(operation, Optional.fromNullable(value1), Optional.fromNullable(value2));
    }


}
