package com.seoi.browser;

import com.seoi.core.dto.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shuaiqi
 * @create 2018-07-23 15:52
 * @desc security controller
 **/
@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //原请求信息的缓存及恢复
    private RequestCache requestCache = new HttpSessionRequestCache();

    //用于重定向
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public BaseResponse requiredAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            final String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是： {}" + redirectUrl);
            if (StringUtils.endsWithIgnoreCase(redirectUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, "/login.html");
            }
        }

        return new BaseResponse("访问的服务需要认证，请引导用户到登录页");
    }

}