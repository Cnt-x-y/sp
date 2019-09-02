package com.xtt.gatewaycenter.filter;

/**
 * @Author xuett
 * @Date 2019/9/2 17:23
 */
public enum ZuulFilterType {
    /**
     * 前置过滤器
     */
    PRE("pre");

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
