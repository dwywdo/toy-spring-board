package com.dwywdo.toyspringboard.controller;

import com.dwywdo.toyspringboard.model.Post;
import com.dwywdo.toyspringboard.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

// todo. Implement PostService to distinguish from Controller
@RestController
@RequestMapping("/board")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // todo. Make use of @RequestBody for getting data with HTTP Request Body
    @PostMapping("/upload")
    public @ResponseBody Post uploadPost(@RequestParam(value="user", defaultValue="Anonymous") String userName,
                           @RequestParam(value="title", defaultValue="defaultTitle") String title,
                           @RequestParam(value="content", defaultValue="defaultContent") String content){
        Post newPost = new Post();
        newPost.setAuthor(userName);
        newPost.setTitle(title);
        newPost.setContent(content);

        return postService.uploadPost(newPost);
    }

    @GetMapping("/retrieve/all")
    public @ResponseBody Page<Post> getAllPosts(Pageable pageable){
        return postService.getAllPosts(pageable);
    }

}
