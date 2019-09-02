package com.xtt.manager.service;

import com.xtt.common.CommonConstant;
import com.xtt.productcenter.web.HelloServiceRemoteApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author xuett
 * @Date 2019/9/2 11:26
 */
@FeignClient(value = CommonConstant.PRODUCT_CENTER, fallback = HelloServiceFeignClientFallback.class)
public interface HelloServiceFeignClient extends HelloServiceRemoteApi {
}
