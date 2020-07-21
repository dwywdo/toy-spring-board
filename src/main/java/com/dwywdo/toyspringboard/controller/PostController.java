package com.dwywdo.toyspringboard.controller;

import com.dwywdo.toyspringboard.model.Post;
import com.dwywdo.toyspringboard.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/board")
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/upload")
    public @ResponseBody Post uploadPost(@RequestBody Post newPost){
        logger.info("uploadPost");
        return postService.uploadPost(newPost);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Post> getPost(@PathVariable long id){
        logger.info("getPost");
        return postService.getPost(id);
    }

    @GetMapping("/retrieve/all")
    public @ResponseBody Page<Post> getAllPosts(Pageable pageable){
        logger.info("getAllPosts");
        return postService.getAllPosts(pageable);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deletePost(@PathVariable long id){
        logger.info("deletePost");
        return postService.deletePost(id);
    }



}
