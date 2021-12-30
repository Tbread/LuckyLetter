package com.newyear.luckyletter.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class SignUpRequestDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
