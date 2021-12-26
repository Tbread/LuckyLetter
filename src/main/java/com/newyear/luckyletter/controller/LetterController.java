package com.newyear.luckyletter.controller;

import com.newyear.luckyletter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;

}
