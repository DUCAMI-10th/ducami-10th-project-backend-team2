package com.ducami.intro.domain.notice.dto;

import com.ducami.intro.domain.notice.entity.Notice;
import java.time.LocalDateTime;

public record NoticeResponse(
    Long id,
    String title,
    String content,
    String author,
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