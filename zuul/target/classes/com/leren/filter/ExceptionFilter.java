package com.leren.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lee
 * @Date:15/03/2018
 */


public class ExceptionFilter extends ZuulFilter {

    private final String TYPE = "error";

    private Logger logger = LoggerFactory.getLogger(ExceptionFilter.class);

    @Override
    public String filterType() {
        return TYPE;
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
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        Throwable throwable = ctx.getThrowable();

        logger.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
        ctx.set("error.status_code", ctx.getResponseStatusCode());
        ctx.set("error.exception", throwable.getCause());

        return null;
    }
}
