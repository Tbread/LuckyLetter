package com.newyear.luckyletter.repository;

import com.newyear.luckyletter.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
