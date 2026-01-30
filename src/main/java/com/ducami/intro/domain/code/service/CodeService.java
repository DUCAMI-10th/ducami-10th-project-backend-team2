package com.ducami.intro.domain.code.service;

import com.ducami.intro.domain.code.dto.CodeResponse;
import com.ducami.intro.domain.code.entity.CodeExample;
import com.ducami.intro.domain.code.repository.CodeExampleRepository;
import com.ducami.intro.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CodeService {

    private final CodeExampleRepository codeExampleRepository;

    public CodeResponse getRandomCode() {
        CodeExample codeExample = codeExampleRepository.findRandomCode()
                .orElseThrow(() -> CustomException.notFound("코드 예제가 없습니다."));

        log.info("Random code fetched: {}", codeExample.getTitle());
        return CodeResponse.from(codeExample);
    }
}