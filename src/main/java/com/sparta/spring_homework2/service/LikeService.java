package com.sparta.spring_homework2.service;

import com.sparta.spring_homework2.dto.LikeRequestDto;
import com.sparta.spring_homework2.model.Like;
import com.sparta.spring_homework2.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    public Long update(LikeRequestDto requestDto) {
        Like like = new Like(requestDto.getUsername(), requestDto.getCommentId());

        if (requestDto.getAction().equals("like")) {
            likeRepository.save(like);
        }else {
            likeRepository.delete(like);
        }

        return likeRepository.countByCommentId(requestDto.getCommentId());
    }
}
