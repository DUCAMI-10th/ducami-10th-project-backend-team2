package com.ducami.intro.domain.notice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "공지사항 작성/수정 요청")
public record NoticeRequest(
        @Schema(description = "공지사항 제목", example = "2026년 신입 부원 모집 안내", required = true)
        @NotBlank(message = "제목을 입력해주세요")
        String title,

        @Schema(description = "공지사항 내용", example = "2026년 1학기 신입 부원을 모집합니다...", required = true)
        @NotBlank(message = "내용을 입력해주세요")
        String content,

        @Schema(description = "작성자", example = "관리자", required = true)
        @NotBlank(message = "작성자를 입력해주세요")
        String author
) {}