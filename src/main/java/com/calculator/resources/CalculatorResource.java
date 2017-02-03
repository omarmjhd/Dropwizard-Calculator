package com.calculator.resources;


import com.calculator.representations.ResultRepresentation;
import com.calculator.services.CalculatorService;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("calculator")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorResource {

    public CalculatorResource() { //According to Milo, this Resource shouldnt be driving the operations, but rather just connect to a service that interfaces with a DB or something of the like to pull a result
    }

    @GET
    @Timed
    public ResultRepresentation calculate(@QueryParam("operation") String operation, @QueryParam("value1") float value1, @QueryParam("value2") float value2) { //@QueryParam("name") maps the name field in the query to name object in param

        CalculatorService calculator = new CalculatorService();

        return calculator.calculate(operation, value1, value2);
    }


}
