package com.newyear.luckyletter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JwtToken {
    private String token;

    @Builder
    public JwtToken(String token){
        this.token = token;
    }
}
