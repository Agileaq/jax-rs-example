package com.personal.arc.jaxrs.example.interfaces;

import com.personal.arc.jaxrs.example.dto.Response;
import com.personal.arc.jaxrs.example.reqparam.WalletParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Arc on 8/1/2017.
 */
@Path("wallet")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IWalletResource {
    @POST
    @Path("dep")
    Response<Void> deposit(WalletParam depMoney);
    @POST
    @Path("wtd")
    Response<Void> withdraw(WalletParam wtdMoney);
}
