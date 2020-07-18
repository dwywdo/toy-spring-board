package com.dwywdo.toyspringboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

// todo. Implement PostService to distinguish from Controller
@RestController
@RequestMapping("/board")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // todo. Make use of @RequestBody for getting data with HTTP Request Body
    @PostMapping("/upload")
    public @ResponseBody String uploadPost(@RequestParam(value="user", defaultValue="Anonymous") String userName,
                           @RequestParam(value="title", defaultValue="defaultTitle") String title,
                           @RequestParam(value="content", defaultValue="defaultContent") String content){
        Post newPost = new Post();
        newPost.setAuthor(userName);
        newPost.setTitle(title);
        newPost.setContent(content);
        postRepository.save(newPost);

        return "Post has been uploaded";
    }

    @GetMapping("/retrieve/all")
    public @ResponseBody Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}
