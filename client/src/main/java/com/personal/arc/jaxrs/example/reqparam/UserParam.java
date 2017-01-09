package com.personal.arc.jaxrs.example.reqparam;

/**
 * Created by Arc on 8/1/2017.
 */
public class UserParam {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public UserParam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserParam setName(String name) {
        this.name = name;
        return this;
    }
}
