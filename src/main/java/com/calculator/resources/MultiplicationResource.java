package com.calculator.resources;

import com.calculator.api.ResultRepresentation;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("calculator/multiply")
@Produces(MediaType.APPLICATION_JSON)
public class MultiplicationResource {

    public MultiplicationResource() {
    }

    @GET
    @Timed
    public ResultRepresentation multiplyValues(@QueryParam("value1") float value1, @QueryParam("value2") float value2) { //@QueryParam("name") maps the name field in the query to name object in param

        final float product = value1 * value2;

        return new ResultRepresentation(product, "*", value1, value2);
    }


}