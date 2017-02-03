package com.calculator.resources;

import com.calculator.api.ResultRepresentation;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("calculator/subtract")
@Produces(MediaType.APPLICATION_JSON)
public class SubtractionResource {


    public SubtractionResource() {
    }

    @GET
    @Timed
    public ResultRepresentation subtractValues(@QueryParam("value1") float value1, @QueryParam("value2") float value2) { //@QueryParam("name") maps the name field in the query to name object in param

        final float difference = value1 - value2;

        return new ResultRepresentation(difference, "-", value1, value2);
    }


}
