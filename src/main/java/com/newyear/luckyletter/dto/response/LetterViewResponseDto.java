package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class LetterViewResponseDto {
    private boolean success;
    private String message;
    private String title;
    private String writer;
    private String contents;
    private LocalDateTime createdAt;

    @Builder
    public LetterViewResponseDto(boolean success, String message, String title, String writer, String contents, LocalDateTime createdAt) {
        this.success = success;
        this.message = message;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.createdAt = createdAt;
    }
}
