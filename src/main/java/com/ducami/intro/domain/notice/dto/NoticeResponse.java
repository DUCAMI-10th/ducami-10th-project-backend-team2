package com.ducami.intro.domain.notice.dto;

import com.ducami.intro.domain.notice.entity.Notice;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "공지사항 응답")
public record NoticeResponse(
        @Schema(description = "공지사항 ID", example = "1")
        Long id,

        @Schema(description = "공지사항 제목", example = "2025년 신입 부원 모집 안내")
        String title,

        @Schema(description = "공지사항 내용", example = "2025년 1학기 신입 부원을 모집합니다...")
        String content,

        @Schema(description = "작성자", example = "관리자")
        String author,

        @Schema(description = "작성일시", example = "2025-02-02T10:00:00")
        LocalDateTime createdAt
) {
    public static NoticeResponse from(Notice notice) {
        return new NoticeResponse(
                notice.getId(),
                notice.getTitle(),
                notice.getContent(),
                notice.getAuthor(),
                notice.getCreatedAt()
        );
    }
}