package com.newyear.luckyletter.service;

import com.newyear.luckyletter.dto.JwtToken;
import com.newyear.luckyletter.dto.request.LoginRequestDto;
import com.newyear.luckyletter.dto.request.SignUpRequestDto;
import com.newyear.luckyletter.dto.response.LoginResponseDto;
import com.newyear.luckyletter.dto.response.SignUpResponseDto;
import com.newyear.luckyletter.jwt.JwtTokenProvider;
import com.newyear.luckyletter.model.Account;
import com.newyear.luckyletter.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("{$etc.salt}")
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
        if (accountRepository.findByUsername(username) != null) {
            signUpResponseDto = SignUpResponseDto.builder()
                    .message("이미 존재하는 아이디입니다.")
                    .success(false)
                    .username(username)
                    .build();
        } else {
            String password = passwordEncoder.encode(signUpRequestDto.getPassword());
            String uuid = UUID.randomUUID().toString();
            Account account = Account.builder()
                    .username(username)
                    .password(password)
                    .uuid(uuid)
                    .build();
            accountRepository.save(account);
            signUpResponseDto = SignUpResponseDto.builder()
                    .message("성공적으로 가입이 완료되었습니다.")
                    .success(true)
                    .username(username)
                    .uuid(uuid)
                    .build();

        }
        return signUpResponseDto;
    }


    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = null;
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        if(username == null || password == null){
            loginResponseDto = LoginResponseDto.builder()
                    .message("아이디 또는 비밀번호가 입력되지 않았습니다.")
                    .success(false)
                    .build();
        }
        Account account = accountRepository.findByUsername(username);
        if(account == null || !passwordEncoder.matches(password,account.getPassword())){
            loginResponseDto = LoginResponseDto.builder()
                    .success(false)
                    .message("아이디 또는 비밀번호가 올바르지 않습니다").build();
        }
        if(account != null && passwordEncoder.matches(password, account.getPassword())){
            Authentication usernamePassword = new UsernamePasswordAuthenticationToken(username,password);
            Authentication authentication = authenticationManager.authenticate(usernamePassword);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            JwtToken jwtToken = JwtToken.builder()
                    .token(jwtTokenProvider.createToken(Long.toString(account.getId()),account.getUsername()))
                    .build();
            loginResponseDto = LoginResponseDto.builder()
                    .success(true)
                    .message("성공적으로 로그인 하였습니다.")
                    .token(jwtToken)
                    .build();
        }
        return loginResponseDto;
    }
}
