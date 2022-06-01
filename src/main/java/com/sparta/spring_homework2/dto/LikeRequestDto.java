package com.sparta.spring_homework2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikeRequestDto {
    private String username;
    private Long commentId;
    private String action;
}
