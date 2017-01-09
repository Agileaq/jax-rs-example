package com.personal.arc.jaxrs.resources;

import com.personal.arc.jaxrs.example.client.ParamThreadLocal;
import com.personal.arc.jaxrs.example.dto.Response;
import com.personal.arc.jaxrs.example.dto.User;
import com.personal.arc.jaxrs.example.interfaces.IUserResource;
import com.personal.arc.jaxrs.example.reqparam.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arc on 8/1/2017.
 */
@RestController
public class UserResource implements IUserResource {

    private static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    public static List<User> fakeUserModels = new ArrayList<>();
    static {
        Long cellphone = 18800000000L;
        String money = "100";
        for(int i=1;i<6;i++) {
            String email = "jaxrs" + i + "@test.com";
            User user = new User();
            user.setCellphone(String.valueOf(cellphone+i))
                    .setId(Long.valueOf(i))
                    .setMoney(Double.parseDouble(String.valueOf(Integer.valueOf(money)+i)))
                    .setName("all_me")
                    .setEmail(email);
            fakeUserModels.add(user);
        }
    }
    @Override
    public Response<List<User>> queryUser(UserParam userParam) {

        Long operatorId = ParamThreadLocal.getOperatorId();
        LOGGER.info("Operator : " + operatorId + " called query User api....");

        List<User> users = new ArrayList<>();
        if(userParam.getId() != null) {
            for(User user : fakeUserModels) {
                if(user.getId().equals(userParam.getId())) {
                    users.add(user);
                }
            }
        }

        if(userParam.getName() != null) {
            for(User user : fakeUserModels) {
                if(user.getName().equals(userParam.getName())) {
                    users.add(user);
                }
            }
        }
        return Response.success(users);
    }
}
