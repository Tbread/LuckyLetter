package com.newyear.luckyletter.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
