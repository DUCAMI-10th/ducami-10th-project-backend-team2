package com.ducami.intro.domain.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "로그인 응답")
public class LoginResponse {

    @Schema(description = "응답 메시지", example = "로그인 성공")
    private String message;

    @Schema(description = "세션 ID (디버깅용)")
    private String sessionId;
}