package com.sparta.spring_homework2.service;


import com.sparta.spring_homework2.model.Post;
import com.sparta.spring_homework2.repository.PostRepository;
import com.sparta.spring_homework2.dto.PostUpdateRequestDto;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto updateRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당하는 아이디가 없습니다."));

        post.update(updateRequestDto);
        return post.getId();
    }
}
