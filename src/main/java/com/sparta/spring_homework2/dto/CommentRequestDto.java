package com.sparta.spring_homework2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentRequestDto {
    private String username;
    private String content;
    private Long postNum;
//    private Long likeCount;
//    private boolean likeByMe;
}
