package com.ducami.intro.domain.admin.controller;

import com.ducami.intro.domain.admin.dto.LoginRequest;
import com.ducami.intro.domain.admin.dto.LoginResponse;
import com.ducami.intro.domain.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Admin", description = "관리자 API")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(
            summary = "관리자 로그인",
            description = "관리자 계정으로 로그인합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request,
            HttpSession session) {
        LoginResponse response = adminService.login(request, session);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "관리자 로그아웃",
            description = "관리자 로그아웃하여 세션을 종료합니다."
    )
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpSession session) {
        adminService.logout(session);
        return ResponseEntity.ok(Map.of("message", "로그아웃 성공"));
    }

    @Operation(
            summary = "인증 상태 확인",
            description = "현재 세션의 관리자 인증 상태를 확인합니다."
    )
    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkAuth(HttpSession session) {
        boolean isAdmin = adminService.isAdmin(session);
        return ResponseEntity.ok(Map.of("isAuthenticated", isAdmin));
    }
}