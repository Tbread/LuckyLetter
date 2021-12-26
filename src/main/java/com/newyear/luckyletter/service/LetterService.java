package com.newyear.luckyletter.service;

import com.newyear.luckyletter.dto.response.LetterListResponseDto;
import com.newyear.luckyletter.model.Letter;
import com.newyear.luckyletter.repository.AccountRepository;
import com.newyear.luckyletter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private final AccountRepository accountRepository;

    public List<LetterListResponseDto> viewList(UserDetails userDetails){
        Long userId = accountRepository.findByUsername(userDetails.getUsername()).getId();
        List<Letter> letters = letterRepository.findAllByUserId(userId);
        List<LetterListResponseDto> letterListResponseDtos = new ArrayList<>();
        for(Letter letter:letters){
            LetterListResponseDto letterListResponseDto = LetterListResponseDto.builder()
                    .title(letter.getTitle())
                    .writer(letter.getWriter())
                    .build();
            letterListResponseDtos.add(letterListResponseDto);
        }
        return letterListResponseDtos;
    }
}
