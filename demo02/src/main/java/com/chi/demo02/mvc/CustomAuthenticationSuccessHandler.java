package com.chi.demo02.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // 調用父類的方法來獲取重定向 URL
        String targetUrl = super.determineTargetUrl(request, response);

        // 去除 URL 中的 ?continue 參數
        if (targetUrl.contains("?continue")) {
            targetUrl = targetUrl.substring(0, targetUrl.indexOf("?continue"));
        }

        return targetUrl;
    }
}