package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpResponseDto {
    private boolean success;
    private String message;
    private String username;

    @Builder
    public SignUpResponseDto(boolean success,String message,String username){
        this.success = success;
        this.message = message;
        this.username = username;
    }

}
