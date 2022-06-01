package com.sparta.spring_homework2.model;

import com.sparta.spring_homework2.dto.CommentRequestDto;
import com.sparta.spring_homework2.dto.CommentUpdateRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long postNum;

    @Column
    private Long likeCount;

    @Column
    private boolean likeByMe;


    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.postNum = requestDto.getPostNum();
    }

    public void update(CommentUpdateRequestDto requestDto) {

        this.content = requestDto.getContent();
    }

}
