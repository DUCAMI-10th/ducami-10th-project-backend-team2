package com.ducami.intro.domain.code.controller;

import com.ducami.intro.domain.code.dto.CodeResponse;
import com.ducami.intro.domain.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/random")
    public ResponseEntity<CodeResponse> getRandomCode() {
        CodeResponse response = codeService.getRandomCode();
        return ResponseEntity.ok(response);
    }
}