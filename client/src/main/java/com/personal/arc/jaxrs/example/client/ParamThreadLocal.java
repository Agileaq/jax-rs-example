package com.personal.arc.jaxrs.example.client;

/**
 * Created by Arc on 8/1/2017.
 */
public class ParamThreadLocal {
    private static final ThreadLocal<Long> operatorId = new ThreadLocal<Long>();

    public static Long getOperatorId() {
        return operatorId.get();
    }
    public static void setOperatorId(Long value) {
        operatorId.set(value);
    }
    public static void clear() {
        operatorId.remove();
    }
}
