package com.ducami.intro.domain.notice.service;

import com.ducami.intro.domain.notice.dto.NoticeRequest;
import com.ducami.intro.domain.notice.dto.NoticeResponse;
import com.ducami.intro.domain.notice.entity.Notice;
import com.ducami.intro.domain.notice.repository.NoticeRepository;
import com.ducami.intro.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResponse> findAll() {
        return noticeRepository.findAll().stream()
                .map(NoticeResponse::from)
                .collect(Collectors.toList());
    }

    public NoticeResponse findById(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> CustomException.notFound("해당 공지사항이 없습니다. id=" + id));
        return NoticeResponse.from(notice);
    }

    @Transactional
    public NoticeResponse save(NoticeRequest request) {
        Notice notice = Notice.builder()
                .title(request.title())
                .content(request.content())
                .author(request.author())
                .build();
        
        Notice savedNotice = noticeRepository.save(notice);
        log.info("Notice created: {}", savedNotice.getTitle());
        return NoticeResponse.from(savedNotice);
    }

    @Transactional
    public NoticeResponse update(Long id, NoticeRequest request) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> CustomException.notFound("수정할 공지사항이 없습니다. id=" + id));
        
        notice.update(request.title(), request.content());
        log.info("Notice updated: {}", notice.getTitle());
        return NoticeResponse.from(notice);
    }

    @Transactional
    public void delete(Long id) {
        if (!noticeRepository.existsById(id)) {
            throw CustomException.notFound("삭제할 공지사항이 없습니다. id=" + id);
        }
        noticeRepository.deleteById(id);
        log.info("Notice deleted: id={}", id);
    }
}