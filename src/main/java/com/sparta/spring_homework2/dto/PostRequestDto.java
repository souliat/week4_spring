package com.sparta.spring_homework2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostRequestDto {
    private String username;

    private String title;

    private String content;

    private String password;

}
