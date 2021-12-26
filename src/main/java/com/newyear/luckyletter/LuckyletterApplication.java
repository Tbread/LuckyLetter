package com.newyear.luckyletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LuckyletterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyletterApplication.class, args);
    }

}
