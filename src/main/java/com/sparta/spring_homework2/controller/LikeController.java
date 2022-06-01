package com.sparta.spring_homework2.controller;

import com.sparta.spring_homework2.dto.LikeRequestDto;
import com.sparta.spring_homework2.model.Like;
import com.sparta.spring_homework2.repository.LikeRepository;
import com.sparta.spring_homework2.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/api/heart/update")
    @ResponseBody
    public Long updateLike(@RequestBody LikeRequestDto requestDto) {
        return likeService.update(requestDto);
    }
}
