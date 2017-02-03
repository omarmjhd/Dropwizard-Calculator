package com.calculator.resources;

import com.calculator.api.ResultRepresentation;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculator/add")
@Produces(MediaType.APPLICATION_JSON)
public class AdditionResource {


    public AdditionResource() {
    }

    @GET
    @Timed
    public ResultRepresentation addValues(@QueryParam("value1") float value1, @QueryParam("value2") float value2) { //@QueryParam("name") maps the name field in the query to name object in param

        final float sum = value1 + value2;

        return new ResultRepresentation(sum, "+", value1, value2);
    }


}
