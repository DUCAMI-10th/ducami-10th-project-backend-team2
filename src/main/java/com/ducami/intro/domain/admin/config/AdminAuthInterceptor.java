package com.ducami.intro.domain.admin.config;

import com.ducami.intro.global.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String method = request.getMethod();
        String uri = request.getRequestURI();

        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;
        }

        if ("GET".equalsIgnoreCase(method)) {
            return true;
        }

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("admin") == null) {
            log.warn("Unauthorized {} request to: {}", method, uri);
            throw CustomException.unauthorized("인증이 필요합니다.");
        }

        Boolean isAdmin = (Boolean) session.getAttribute("admin");
        if (!isAdmin) {
            throw CustomException.forbidden("관리자 권한이 필요합니다.");
        }

        log.info("Authorized {} request to: {} by admin", method, uri);
        return true;
    }
}