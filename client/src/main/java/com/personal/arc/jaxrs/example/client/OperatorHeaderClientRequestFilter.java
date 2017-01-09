package com.personal.arc.jaxrs.example.client;

import javax.annotation.Priority;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arc on 12/7/2016.
 */
@Provider
// 9 is before UUIDHeaderFilter
// in jax-rs, If you don't config the priority the default value is 5000.
@Priority(9)
public class OperatorHeaderClientRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {

        // we also could put jwt here for stateless authorization of api call
        if(ParamThreadLocal.getOperatorId() != null) {
            List<Object> objs = new LinkedList<>();
            objs.add(ParamThreadLocal.getOperatorId().toString());
            requestContext.getHeaders().put("operatorId", objs);
        }

    }

}
