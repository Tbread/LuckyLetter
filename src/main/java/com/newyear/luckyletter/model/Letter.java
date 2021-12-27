package com.newyear.luckyletter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Letter extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Builder
    public Letter(String writer,String contents,Long userId, String title){
        this.writer = writer;
        this.contents = contents;
        this.userId = userId;
        this.title = title;
    }
}
