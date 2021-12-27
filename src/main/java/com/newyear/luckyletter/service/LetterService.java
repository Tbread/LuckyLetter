package com.newyear.luckyletter.service;

import com.newyear.luckyletter.dto.request.LetterRequestDto;
import com.newyear.luckyletter.dto.response.LetterListResponseDto;
import com.newyear.luckyletter.dto.response.LetterWriteResponseDto;
import com.newyear.luckyletter.model.Account;
import com.newyear.luckyletter.model.Letter;
import com.newyear.luckyletter.repository.AccountRepository;
import com.newyear.luckyletter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public LetterWriteResponseDto write(LetterRequestDto letterRequestDto) {
        LetterWriteResponseDto letterWriteResponseDto;
        Optional<Account> account = accountRepository.findById(letterRequestDto.getUserId());
        if (!account.isPresent()) {
            letterWriteResponseDto = LetterWriteResponseDto.builder()
                    .success(false)
                    .message("존재하지 않는 유저입니다.")
                    .build();
        } else {
            Letter letter = Letter.builder()
                    .title(letterRequestDto.getTitle())
                    .contents(letterRequestDto.getContents())
                    .writer(letterRequestDto.getWriter())
                    .userId(letterRequestDto.getUserId())
                    .build();
            letterRepository.save(letter);
            letterWriteResponseDto = LetterWriteResponseDto.builder()
                    .title(letterRequestDto.getTitle())
                    .writer(letterRequestDto.getWriter())
                    .contents(letterRequestDto.getContents())
                    .success(true)
                    .message("성공적으로 편지가 작성되었습니다.")
                    .build();
        }
        return letterWriteResponseDto;
    }

    public List<LetterListResponseDto> viewList(UserDetails userDetails) {
        Long userId = accountRepository.findByUsername(userDetails.getUsername()).getId();
        List<Letter> letters = letterRepository.findAllByUserId(userId);
        List<LetterListResponseDto> letterListResponseDtos = new ArrayList<>();
        for (Letter letter : letters) {
            LetterListResponseDto letterListResponseDto = LetterListResponseDto.builder()
                    .title(letter.getTitle())
                    .writer(letter.getWriter())
                    .build();
            letterListResponseDtos.add(letterListResponseDto);
        }
        return letterListResponseDtos;
    }
}
