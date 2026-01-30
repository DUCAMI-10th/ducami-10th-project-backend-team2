package com.ducami.intro.domain.code.dto;

import com.ducami.intro.domain.code.entity.CodeExample;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CodeResponse {
    private Long id;
    private String title;
    private String code;
    private String difficulty;
    private String category;
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