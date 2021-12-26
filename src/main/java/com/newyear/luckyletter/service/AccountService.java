package com.newyear.luckyletter.service;

import com.newyear.luckyletter.dto.request.SignUpRequestDto;
import com.newyear.luckyletter.dto.response.SignUpResponseDto;
import com.newyear.luckyletter.model.Account;
import com.newyear.luckyletter.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;

    @Value("{$spring.datasource.salt}")
    private String salt;


    @Transactional
    public SignUpResponseDto register(SignUpRequestDto signUpRequestDto) {
        String username = signUpRequestDto.getUsername();
        SignUpResponseDto signUpResponseDto;
        if(username == null||signUpRequestDto.getPassword() == null){
            signUpResponseDto = SignUpResponseDto.builder()
                    .message("아이디 또는 비밀번호가 입력되지 않았습니다.")
                    .success(false)
                    .build();
            return signUpResponseDto;
        }
        if (accountRepository.findByUsername(username).isPresent()) {
            signUpResponseDto = SignUpResponseDto.builder()
                    .message("이미 존재하는 아이디입니다.")
                    .success(false)
                    .username(username)
                    .build();
        } else {
            String password = passwordEncoder.encode(signUpRequestDto.getPassword());
            Account account = Account.builder()
                    .username(username)
                    .password(password)
                    .build();
            accountRepository.save(account);
            signUpResponseDto = SignUpResponseDto.builder()
                    .message("성공적으로 가입이 완료되었습니다.")
                    .success(true)
                    .username(username)
                    .build();

        }
        return signUpResponseDto;
    }
}
