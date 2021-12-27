package com.newyear.luckyletter.controller;

import com.newyear.luckyletter.dto.request.LetterRequestDto;
import com.newyear.luckyletter.dto.response.LetterListResponseDto;
import com.newyear.luckyletter.dto.response.LetterWriteResponseDto;
import com.newyear.luckyletter.service.LetterService;
import com.newyear.luckyletter.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.newyear.luckyletter.utils.ApiResultMaker.*;

@RestController
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;

    @PostMapping("/letter")
    public ApiResult<LetterWriteResponseDto> write(@RequestBody LetterRequestDto letterRequestDto){
        return success(letterService.write(letterRequestDto));
    }

    @GetMapping("/letter")
    public ApiResult<List<LetterListResponseDto>> viewList(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return success(letterService.viewList(userDetails));
    }
}
