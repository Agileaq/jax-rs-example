package com.personal.arc.jaxrs.example;

import com.personal.arc.jaxrs.example.client.JaxrsExampleFacade;
import com.personal.arc.jaxrs.example.client.ParamThreadLocal;
import com.personal.arc.jaxrs.example.dto.Response;
import com.personal.arc.jaxrs.example.dto.User;
import com.personal.arc.jaxrs.example.reqparam.UserParam;
import com.personal.arc.jaxrs.example.reqparam.WalletParam;

import java.util.List;

/**
 * Created by Arc on 8/1/2017.
 */
public class ClientMainDEMO {
    public static void main(String args[]) {

        JaxrsExampleFacade jaxrsExampleFacade = new JaxrsExampleFacade("http://localhost:8080/ws/jaxrs");
        // case a. 查询出ID为1的用户
        UserParam userParam = new UserParam();
        userParam.setId(1L);
        Response<List<User>> queryUserResponse1 = jaxrsExampleFacade.getUserResource().queryUser(userParam);
        // 打印出查出用户具体信息
        System.out.println(queryUserResponse1);
        // 存一些钱进去
        WalletParam walletDepositParam = new WalletParam();
        walletDepositParam.setUserId(1L);
        walletDepositParam.setDepositMoney(5.32);
        jaxrsExampleFacade.getWalletResource().deposit(walletDepositParam);
        // 再查询用户具体信息, 发现用户的钱变多了.
        Response<List<User>> queryUserResponse2 = jaxrsExampleFacade.getUserResource().queryUser(userParam);
        System.out.println(queryUserResponse2);

        // case b. 设置一下操作者为3L, 在执行完后查看服务端日志, 记录了3L进行了用户查询操作的日志
        ParamThreadLocal.setOperatorId(3L);
        Response<List<User>> queryUserResponse3 = jaxrsExampleFacade.getUserResource().queryUser(userParam);
        System.out.println(queryUserResponse3);

    }
}
