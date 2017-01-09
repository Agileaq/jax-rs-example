package com.personal.arc.jaxrs.resources;

import com.personal.arc.jaxrs.example.dto.Response;
import com.personal.arc.jaxrs.example.dto.User;
import com.personal.arc.jaxrs.example.interfaces.IWalletResource;
import com.personal.arc.jaxrs.example.reqparam.WalletParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arc on 8/1/2017.
 */
@RestController
public class WalletResource implements IWalletResource {

    @Override
    public Response<Void> deposit(WalletParam depMoney) {
        Long userId = depMoney.getUserId();
        Double money = depMoney.getDepositMoney();
        if(userId == null || money == null) {
            return Response.failure();
        } else {
            for(User user : UserResource.fakeUserModels) {
                if(user.getId().equals(userId)) {
                    //TODO param check
                    user.setMoney(user.getMoney() + money);
                }
            }
            return Response.success();
        }
    }

    @Override
    public Response<Void> withdraw(WalletParam wtdMoney) {
        Long userId = wtdMoney.getUserId();
        Double money = wtdMoney.getWithdrawMoney();
        if(userId == null || money == null) {
            return Response.failure();
        } else {
            for(User user : UserResource.fakeUserModels) {
                if(user.getId().equals(userId)) {
                    //TODO param check
                    user.setMoney(user.getMoney() - money);
                }
            }
            return Response.success();
        }
    }
}
