package com.newyear.luckyletter.dto.response;

import com.newyear.luckyletter.dto.JwtToken;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private boolean success;
    private String message;
    private JwtToken token;

    @Builder
    public LoginResponseDto(boolean success, String message, JwtToken token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }
}
