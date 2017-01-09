package com.personal.arc.jaxrs.example.dto;

import java.io.Serializable;

/**
 * Created by Arc on 14/1/16.
 */
public final class Info implements Serializable {

    private InfoName name;
    private String msg;

    //Note: default constructor is mandatory!!!
    public Info(){
    	
    }
    
    public Info(InfoName name) {
        this.name = name;
    }

    public Info(InfoName name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public InfoName getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }

    public static Info build(InfoName name, String msg){
        return new Info(name, msg);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Info{");
        sb.append("name=").append(name);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
