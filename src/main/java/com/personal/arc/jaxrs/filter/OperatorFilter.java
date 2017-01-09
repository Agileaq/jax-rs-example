package com.personal.arc.jaxrs.filter;

import com.personal.arc.jaxrs.example.client.ParamThreadLocal;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Arc on 9/1/2017.
 */
@Provider
@Priority(9)
public class OperatorFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String headerString = requestContext.getHeaderString("operatorId");
        if(headerString != null) {
            ParamThreadLocal.setOperatorId(Long.valueOf(headerString));
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        ParamThreadLocal.clear();
    }

}
