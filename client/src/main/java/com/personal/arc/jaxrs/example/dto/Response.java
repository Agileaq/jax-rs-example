package com.personal.arc.jaxrs.example.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arc on 14/1/16.
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 4391955854748049770L;
    private static final Info internalError = Info.build(InfoName.INTERNAL_ERROR, "Internal error");

    private String transId;
    private String uuid;
    /** 返回数据 */
    private T data;
    /** 返回信息 */
    private List<Info> info;

    public Response() {
    }

    public Response(List<Info> info) {
        this.info = info;
    }

    public Response(Info info) {
        this.info = Arrays.asList(info);
    }

    public Response(T result) {
        this.data = result;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }

    public List<Info> getInfo() {
        return info;
    }

    public Response setInfo(List<Info> info) {
        this.info = info;
        return this;
    }

    public String getTransId() {
        return transId;
    }

    public Response setTransId(String transId) {
        this.transId = transId;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Response setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public static <T> Response<T> success(T result) {
        return new Response<T>(result);
    }

    public static Response<Void> success() {
        return new Response<Void>();
    }

    public static <T> Response<T> failure(Info info) {
        return new Response<T>(info);
    }

    public static <T> Response<T> failure(List<Info> info) {
        return new Response<T>(info);
    }

    public static <T> Response<T> failure() {
        return new Response<T>(internalError);
    }

    public static <T> Response<T> failure(InfoName name, String errMsg) {
        return failure(Info.build(name, errMsg));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("transId='").append(transId).append('\'');
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", data=").append(data);
        sb.append(", info=").append(info);
        sb.append('}');
        return sb.toString();
    }
}
