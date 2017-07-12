package org.forkjoin.jteach.open;


import org.forkjoin.jteach.open.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.forkjoin.apikit.spring.AccountHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zuoge85@gmail.com on 2017/5/16.
 */
public class OpenApiAccountHandlerInterceptor extends AccountHandlerInterceptor<OpenApiAccount> {
    @Autowired
    private AccountService accountService;

    @Value("${management.context-path}")
    private String managementContextPath;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.isNotEmpty(managementContextPath)) {
            if (request.getRequestURI().startsWith(managementContextPath)) {
                return true;
            }
        }
        if (request.getRequestURI().startsWith("/error")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/ws")) {
            return true;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    protected OpenApiAccount getAccountObject(HttpServletRequest request) throws Exception {
        String accessToken = request.getHeader(ACCOUNT_TOKEN_HEADER_NAME);
        return accountService.getByToken(accessToken);
    }
}
