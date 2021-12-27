package com.newyear.luckyletter.dto.response;

import com.newyear.luckyletter.model.Letter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LetterListResponseDto {
    private String writer;
    private String title;
    private Letter.letterVisual letterVisual;

    @Builder
    public LetterListResponseDto(String writer,String title, Letter.letterVisual letterVisual){
        this.writer = writer;
        this.title = title;
        this.letterVisual = letterVisual;
    }
}
