package com.newyear.luckyletter.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignUpRequestDto {
    private String username;
    private String password;
}
