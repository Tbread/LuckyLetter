package com.newyear.luckyletter.repository;

import com.newyear.luckyletter.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Optional<Account> findById(Long id);
}
