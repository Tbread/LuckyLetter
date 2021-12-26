package com.newyear.luckyletter.service;

import com.newyear.luckyletter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    
}
