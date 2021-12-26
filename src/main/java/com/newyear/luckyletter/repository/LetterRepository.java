package com.newyear.luckyletter.repository;

import com.newyear.luckyletter.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter,Long> {
}
