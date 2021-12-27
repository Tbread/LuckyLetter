package com.newyear.luckyletter.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignUpResponseDto {
    private boolean success;
    private String message;
    private String username;
    private String uuid;

    @Builder
    public SignUpResponseDto(boolean success,String message,String username,String uuid){
        this.success = success;
        this.message = message;
        this.username = username;
        this.uuid = uuid;
    }

}
