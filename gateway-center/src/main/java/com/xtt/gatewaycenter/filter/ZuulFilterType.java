package com.xtt.gatewaycenter.filter;

/**
 * @Author xuett
 * @Date 2019/9/2 17:23
 */
public enum ZuulFilterType {
    /**
     * 被路由之前调用
     */
    PRE("pre"),
    /**
     * 在路由请求时被调用
     */
    ROUTING("routing"),
    /**
     * 在routing 和 error 之后被调用
     */
    POST("post"),
    /**
     * 发生错误时被调用
     */
    ERROR("error");

    String type;

    ZuulFilterType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }}
