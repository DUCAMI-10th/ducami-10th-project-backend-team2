package com.ducami.intro.domain.notice.repository;

import com.ducami.intro.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 기본 CRUD(save, findById, findAll, delete)는 JpaRepository가 제공합니다.
}