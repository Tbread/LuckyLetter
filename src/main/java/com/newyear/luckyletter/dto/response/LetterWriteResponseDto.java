package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LetterWriteResponseDto {

    private boolean success;
    private String message;
    private String writer;
    private String contents;
    private String title;
    private Long userId;


    @Builder
    public LetterWriteResponseDto(String writer, String contents, String title, Long userId, boolean success, String message){
        this.contents = contents;
        this.writer = writer;
        this.title = title;
        this.userId = userId;
        this.success = success;
        this.message = message;
    }

}
