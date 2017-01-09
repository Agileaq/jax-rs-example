package com.personal.arc.jaxrs.example.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.personal.arc.jaxrs.example.interfaces.IUserResource;
import com.personal.arc.jaxrs.example.interfaces.IWalletResource;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Arc on 8/1/2017.
 */
public class JaxrsExampleFacade {

    private String endpoint;
    public JaxrsExampleFacade(String endpoint){
        this.endpoint = endpoint;
        init();
    }
    private IUserResource userResource;
    private IWalletResource walletResource;

    private void init(){
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
        jacksonJsonProvider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UUIDHeaderClientRequestFilter uUIDHeaderClientRequestFilter = new UUIDHeaderClientRequestFilter();
        OperatorHeaderClientRequestFilter operatorHeaderClientRequestFilter = new OperatorHeaderClientRequestFilter();
        List<?> providers = Arrays.asList(jacksonJsonProvider, uUIDHeaderClientRequestFilter,operatorHeaderClientRequestFilter);
        userResource = JAXRSClientFactory.create(endpoint, IUserResource.class, providers);
        walletResource = JAXRSClientFactory.create(endpoint, IWalletResource.class, providers);
    }

    public IUserResource getUserResource() {
        return userResource;
    }

    public IWalletResource getWalletResource() {
        return walletResource;
    }
}
