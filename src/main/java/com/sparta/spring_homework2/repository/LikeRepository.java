package com.sparta.spring_homework2.repository;


import com.sparta.spring_homework2.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Long countByCommentId(Long commentId);
}
