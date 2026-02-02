package com.ducami.intro.domain.admin.service;

import com.ducami.intro.domain.admin.dto.LoginRequest;
import com.ducami.intro.domain.admin.dto.LoginResponse;
import com.ducami.intro.global.exception.CustomException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    public LoginResponse login(LoginRequest request, HttpSession session) {
        if (!adminUsername.equals(request.getUsername()) ||
                !adminPassword.equals(request.getPassword())) {
            throw CustomException.unauthorized("아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("admin", true);
        session.setAttribute("username", request.getUsername());

        log.info("Admin logged in: {}", request.getUsername());

        return LoginResponse.builder()
                .message("로그인 성공")
                .sessionId(session.getId())
                .build();
    }

    public void logout(HttpSession session) {
        session.invalidate();
        log.info("Admin logged out");
    }

    public boolean isAdmin(HttpSession session) {
        Boolean isAdmin = (Boolean) session.getAttribute("admin");
        return isAdmin != null && isAdmin;
    }
}