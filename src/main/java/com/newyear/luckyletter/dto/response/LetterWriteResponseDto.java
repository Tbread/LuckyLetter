package com.newyear.luckyletter.dto.response;

import com.newyear.luckyletter.model.Letter;
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
    private Letter.letterVisual letterVisual;


    @Builder
    public LetterWriteResponseDto(String writer, String contents, String title, Long userId, boolean success, String message,Letter.letterVisual letterVisual){
        this.contents = contents;
        this.writer = writer;
        this.title = title;
        this.userId = userId;
        this.success = success;
        this.message = message;
        this.letterVisual = letterVisual;
    }

}
