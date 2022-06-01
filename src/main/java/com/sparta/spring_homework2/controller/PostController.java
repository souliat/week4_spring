package com.sparta.spring_homework2.controller;

import com.sparta.spring_homework2.model.Post;
import com.sparta.spring_homework2.repository.PostRepository;
import com.sparta.spring_homework2.dto.PostRequestDto;
import com.sparta.spring_homework2.dto.PostUpdateRequestDto;
import com.sparta.spring_homework2.security.UserDetailsImpl;
import com.sparta.spring_homework2.service.PostService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostRepository postRepository;

    private final PostService postService;


    @GetMapping("/write")
    public String writeView() {
        return "write";
    }

    @GetMapping("/index")
    public String indexView() {
        return "index";
    }

    @GetMapping("/api/posts")
    @ResponseBody
    public List<Post> getTotalPosts() {

        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/detail/{id}")
    public String getDetailPosts(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException(""));
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("loginStatus", true);
        }
        model.addAttribute("post", post);
        return "detail";
    }

    @PostMapping("/api/posts")
    @ResponseBody
    public Post savePosts(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @PutMapping("/api/posts/{id}")
    @ResponseBody
    public Long updatePosts(@PathVariable Long id, @RequestBody PostUpdateRequestDto updateRequestDto) {
        postService.update(id, updateRequestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseBody
    public Long deletePosts(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @GetMapping("/api/posts/check")
    @ResponseBody
    public boolean checkPassword(@RequestParam("id") Long id, @RequestParam("password") String password) {
        boolean check = false;
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당하는 아이디가 없습니다."));

        if (post.getPassword().equals(password)) {
            check = true;
        }

        return check;
    }
}
