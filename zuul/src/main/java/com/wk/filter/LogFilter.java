package com.wk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义zuul过滤器
 */
@Component
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //定义过滤器类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //过滤器质性顺序，数字越小，优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否使用过滤器，改为true。默认false
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //自定义过滤器的执行逻辑，根据自己的业务需要来设计
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String  remoteAddr = request.getRemoteAddr();
        System.out.println("访问者IP："+remoteAddr+" 访问地址："+request.getRequestURI());
        return null;
    }
}
