package com.sparta.spring_homework2.model;

import com.sparta.spring_homework2.dto.PostRequestDto;
import com.sparta.spring_homework2.dto.PostUpdateRequestDto;
import com.sparta.spring_homework2.model.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;


    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(PostUpdateRequestDto updateRequestDto) {
        this.title = updateRequestDto.getTitle();
        this.content = updateRequestDto.getContent();
    }
}
