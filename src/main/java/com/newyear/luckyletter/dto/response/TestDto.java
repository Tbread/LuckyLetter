package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class TestDto {
    private String message;

    @Builder
    public TestDto(String message){
        this.message = message;
    }
}
