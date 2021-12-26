package com.newyear.luckyletter.repository;

import com.newyear.luckyletter.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllByUserId(Long id);

    Optional<Letter> findById(Long id);
}
