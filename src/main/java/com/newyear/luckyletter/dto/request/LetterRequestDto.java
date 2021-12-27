package com.newyear.luckyletter.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class LetterRequestDto {

    @NotEmpty
    private Long userId;

    @NotEmpty
    private String contents;

    @NotEmpty
    private String writer;

    @NotEmpty
    private String title;
}
