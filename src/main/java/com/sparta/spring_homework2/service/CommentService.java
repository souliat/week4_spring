package com.sparta.spring_homework2.service;

import com.sparta.spring_homework2.dto.CommentRequestDto;
import com.sparta.spring_homework2.dto.CommentUpdateRequestDto;
import com.sparta.spring_homework2.model.Comment;
import com.sparta.spring_homework2.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 작성
    @Transactional
    public Comment save(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    // 댓글 수정
    @Transactional
    public void update(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 글의 아이디가 없습니다."));

        comment.update(requestDto);
    }
}
