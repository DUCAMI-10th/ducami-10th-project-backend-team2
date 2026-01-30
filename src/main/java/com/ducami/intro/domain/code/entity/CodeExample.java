package com.ducami.intro.domain.code.entity;

import com.ducami.intro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "code_example")
public class CodeExample extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Difficulty difficulty;

    @Column(length = 50)
    private String category;

    @Builder
    public CodeExample(String title, String code, Difficulty difficulty, String category) {
        this.title = title;
        this.code = code;
        this.difficulty = difficulty != null ? difficulty : Difficulty.EASY;
        this.category = category;
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}