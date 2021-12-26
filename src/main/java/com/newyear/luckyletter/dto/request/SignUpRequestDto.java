package com.newyear.luckyletter.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignUpRequestDto {
    private String username;
    private String password;
}
