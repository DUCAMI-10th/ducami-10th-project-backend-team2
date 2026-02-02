package com.ducami.intro.domain.notice.controller;

import com.ducami.intro.domain.notice.dto.NoticeRequest;
import com.ducami.intro.domain.notice.dto.NoticeResponse;
import com.ducami.intro.domain.notice.service.NoticeService;
import com.ducami.intro.global.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Notice", description = "공지사항 API - 공지사항 CRUD 기능을 제공합니다")
@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @Operation(
            summary = "공지사항 전체 조회",
            description = "등록된 모든 공지사항을 최신순으로 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))
            )
    })
    @GetMapping
    public ResponseEntity<List<NoticeResponse>> getAllNotices() {
        return ResponseEntity.ok(noticeService.findAll());
    }

    @Operation(
            summary = "공지사항 상세 조회",
            description = "ID를 통해 특정 공지사항의 상세 정보를 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 공지사항을 찾을 수 없습니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<NoticeResponse> getNotice(
            @Parameter(description = "공지사항 ID", example = "1", required = true)
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(noticeService.findById(id));
    }

    @Operation(
            summary = "공지사항 작성",
            description = "새로운 공지사항을 작성합니다. (관리자 권한 필요)"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "작성 성공",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "인증이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "관리자 권한이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<NoticeResponse> createNotice(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "작성할 공지사항 정보",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NoticeRequest.class))
            )
            @RequestBody NoticeRequest request
    ) {
        return ResponseEntity.ok(noticeService.save(request));
    }

    @Operation(
            summary = "공지사항 수정",
            description = "기존 공지사항을 수정합니다. (관리자 권한 필요)"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "수정 성공",
                    content = @Content(schema = @Schema(implementation = NoticeResponse.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "인증이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "관리자 권한이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 공지사항을 찾을 수 없습니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponse> updateNotice(
            @Parameter(description = "수정할 공지사항 ID", example = "1", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "수정할 공지사항 정보",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NoticeRequest.class))
            )
            @RequestBody NoticeRequest request
    ) {
        return ResponseEntity.ok(noticeService.update(id, request));
    }

    @Operation(
            summary = "공지사항 삭제",
            description = "기존 공지사항을 삭제합니다. (관리자 권한 필요)"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "삭제 성공"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "인증이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "관리자 권한이 필요합니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 공지사항을 찾을 수 없습니다",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(
            @Parameter(description = "삭제할 공지사항 ID", example = "1", required = true)
            @PathVariable Long id
    ) {
        noticeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}