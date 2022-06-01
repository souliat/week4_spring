package com.sparta.spring_homework2.controller;

import com.sparta.spring_homework2.dto.CommentRequestDto;
import com.sparta.spring_homework2.dto.CommentUpdateRequestDto;
import com.sparta.spring_homework2.model.Comment;
import com.sparta.spring_homework2.repository.CommentRepository;
import com.sparta.spring_homework2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    // 댓글 작성
    @PostMapping("/api/comments")
    @ResponseBody
    public Comment saveComments(@RequestBody CommentRequestDto requestDto) {
        return commentService.save(requestDto);
    }

    // 댓글 조회
    @GetMapping("/api/comments/{postNum}")
    @ResponseBody
    public List<Comment> getComments(@PathVariable Long postNum) {
        return commentRepository.findAllByPostNumOrderByCreatedAtDesc(postNum);
    }

    // 댓글 수정
    @PutMapping("/api/comments/{id}")
    @ResponseBody
    public Long updateComments(@PathVariable Long id, @RequestBody CommentUpdateRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    // 댓글 삭제
    @DeleteMapping("api/comments/{id}")
    @ResponseBody
    public Long deleteComments(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
