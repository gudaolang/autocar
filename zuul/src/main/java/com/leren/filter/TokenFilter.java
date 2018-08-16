package com.leren.filter;

import com.leren.service.AuthService;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lee
 * @Date:15/03/2018
 */


public class TokenFilter extends ZuulFilter {

    private final String TYPE = "pre";

    private Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Autowired
    private AuthService authService;

    @Override
    public String filterType() {
        return TYPE;
    }


    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        String token = request.getParameter("token");
//        if (StringUtils.isNotBlank(token)) {
////            authService.checkCode(token);
//            return null;¬
//        } else {
//            HttpServletResponse response = context.getResponse();
//            response.setHeader("content-type", "application/json;charset=UTF-8");
//            DataResult result = new DataResult(HttpStatus.SC_UNAUTHORIZED, "未登录");
//            context.setResponse(response);
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(HttpStatus.SC_OK);
//            context.setResponseBody(JSON.toJSONString(result));
//            logger.info("Ip[{}] 请求/{ {} /} 失败,原因:未登录!", RequestUtil.getIp(request), request.getRequestURL());
//        }
        return null;
    }
}
