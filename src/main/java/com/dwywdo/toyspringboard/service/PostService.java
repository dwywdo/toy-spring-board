package com.dwywdo.toyspringboard.service;

import com.dwywdo.toyspringboard.controller.PostController;
import com.dwywdo.toyspringboard.model.Post;
import com.dwywdo.toyspringboard.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post uploadPost(Post post){
        logger.info("uploadPost");
        return postRepository.save(post);
    }

    public Optional<Post> getPost(long id) {
        logger.info("getPost");
        return postRepository.findById(id);
    }

    public Page<Post> getAllPosts(Pageable pageable){
        logger.info("getAllPosts");
        return postRepository.findAll(pageable);
    }

    public String deletePost(long id) {
        logger.info("deletePost");
        postRepository.deleteById(id);
        return "Post was deleted";
    }

}
