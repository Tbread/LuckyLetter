package com.newyear.luckyletter.controller;

import com.newyear.luckyletter.dto.request.LoginRequestDto;
import com.newyear.luckyletter.dto.request.SignUpRequestDto;
import com.newyear.luckyletter.dto.response.LoginResponseDto;
import com.newyear.luckyletter.dto.response.SignUpResponseDto;
import com.newyear.luckyletter.dto.response.TestDto;
import com.newyear.luckyletter.service.AccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.newyear.luckyletter.utils.ApiResultMaker.*;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/test")
    public ApiResult<TestDto> test(){
        String message = "testMessage";
        TestDto testDto = TestDto.builder()
                .message(message)
                .build();
        return success(testDto);
    }

    @PostMapping("/register")
    public ApiResult<SignUpResponseDto> register(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        return success(accountService.register(signUpRequestDto));
    }

    @PostMapping("/login")
    public ApiResult<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto){
        return success(accountService.login(loginRequestDto));
    }
}
