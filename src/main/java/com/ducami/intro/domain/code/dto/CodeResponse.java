package com.ducami.intro.domain.code.dto;

import com.ducami.intro.domain.code.entity.CodeExample;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(description = "코드 예제 응답")
public class CodeResponse {

    @Schema(description = "코드 ID", example = "1")
    private Long id;

    @Schema(description = "코드 제목", example = "두 수의 덧셈")
    private String title;

    @Schema(description = "코드 내용", example = "a, b = map(int, input().split())\\nprint(a + b)")
    private String code;

    @Schema(description = "난이도", example = "EASY", allowableValues = {"EASY", "MEDIUM", "HARD"})
    private String difficulty;

    @Schema(description = "카테고리", example = "입출력")
    private String category;

    @Schema(description = "생성 시간", example = "2024-01-31T12:00:00")
    private LocalDateTime createdAt;

    public static CodeResponse from(CodeExample codeExample) {
        return CodeResponse.builder()
                .id(codeExample.getId())
                .title(codeExample.getTitle())
                .code(codeExample.getCode())
                .difficulty(codeExample.getDifficulty().name())
                .category(codeExample.getCategory())
                .createdAt(codeExample.getCreatedAt())
                .build();
    }
}