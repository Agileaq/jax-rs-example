package com.personal.arc.jaxrs.example.interfaces;

import com.personal.arc.jaxrs.example.dto.Response;
import com.personal.arc.jaxrs.example.dto.User;
import com.personal.arc.jaxrs.example.reqparam.UserParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Arc on 8/1/2017.
 */
@Path("user")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IUserResource {
    @POST
    @Path("query")
    Response<List<User>> queryUser(UserParam userParam);

}
