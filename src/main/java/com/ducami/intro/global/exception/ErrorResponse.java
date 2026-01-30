package com.ducami.intro.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "에러 응답")
public class ErrorResponse {

    @Schema(description = "에러 발생 시간", example = "2024-01-31T12:00:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP 상태 코드", example = "400")
    private int status;

    @Schema(description = "에러 타입", example = "Bad Request")
    private String error;

    @Schema(description = "에러 메시지", example = "잘못된 요청입니다.")
    private String message;

    @Schema(description = "상세 에러 정보")
    private Map<String, String> details;
}