package com.sparta.spring_homework2.repository;

import com.sparta.spring_homework2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
    List<Comment> findAllByPostNumOrderByCreatedAtDesc(Long postNum);
}
