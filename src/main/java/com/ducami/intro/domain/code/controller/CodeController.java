package com.ducami.intro.domain.code.controller;

import com.ducami.intro.domain.code.dto.CodeResponse;
import com.ducami.intro.domain.code.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Code", description = "코드 예제 API")
@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @Operation(
            summary = "랜덤 코드 조회",
            description = "데이터베이스에서 랜덤으로 하나의 Python 코드 예제를 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = CodeResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "코드 예제가 없습니다."
            )
    })
    @GetMapping("/random")
    public ResponseEntity<CodeResponse> getRandomCode() {
        CodeResponse response = codeService.getRandomCode();
        return ResponseEntity.ok(response);
    }
}