package com.newyear.luckyletter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Letter extends TimeStamped{
    public enum letterVisual {
        LUCKYBAG,MONEYBAG
    }

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Letter.letterVisual letterVisual;

    @Builder
    public Letter(String writer,String contents,Long userId, String title, letterVisual letterVisual){
        this.writer = writer;
        this.contents = contents;
        this.userId = userId;
        this.title = title;
        this.letterVisual = letterVisual;
    }
}
