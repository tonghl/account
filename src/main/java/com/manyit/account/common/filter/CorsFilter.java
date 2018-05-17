package com.manyit.account.common.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Copyright ® 上海旻瑞信息技术有限公司版权所有。</p>
 * 类名:CorsFilter
 * 创建人:童海龙    创建时间:2018/5/17
 * 解决ajax跨域
 */
@Component
public class CorsFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) resp;
        System.out.println("=================================="+req.getRemoteAddr());

        // 这里最好不要写通配符，如果允许多个域请求数据的话，可以直接用逗号隔开："http://www.baidu.com,http://google.com"

        res.setHeader("Access-Control-Allow-Origin", "*");

        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");

        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");

        //res.setHeader("Access-Control-Allow-Credentials","false");

        chain.doFilter(req, resp);

    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
