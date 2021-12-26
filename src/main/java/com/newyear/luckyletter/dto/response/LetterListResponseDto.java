package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LetterListResponseDto {
    private String writer;
    private String title;

    @Builder
    public LetterListResponseDto(String writer,String title){
        this.writer = writer;
        this.title = title;
    }
}
