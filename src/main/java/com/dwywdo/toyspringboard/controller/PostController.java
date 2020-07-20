package com.dwywdo.toyspringboard.controller;

import com.dwywdo.toyspringboard.model.Post;
import com.dwywdo.toyspringboard.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/board")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // todo. Make use of @RequestBody for getting data with HTTP Request Body
    @PostMapping("/upload")
    public @ResponseBody Post uploadPost(@RequestBody Post newPost){
        return postService.uploadPost(newPost);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Post> getPost(@PathVariable long id){
        return postService.getPost(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deletePost(@PathVariable long id){
        return postService.deletePost(id);
    }

    @GetMapping("/retrieve/all")
    public @ResponseBody Page<Post> getAllPosts(Pageable pageable){
        return postService.getAllPosts(pageable);
    }

}
