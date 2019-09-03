package com.xtt.gatewaycenter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xuett
 * @Date 2019/9/2 17:19
 */
@Component
public class AccessFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return ZuulFilterType.PRE.getType();
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
