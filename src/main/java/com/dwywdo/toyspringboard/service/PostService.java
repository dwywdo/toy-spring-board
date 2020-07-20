package com.dwywdo.toyspringboard.service;

import com.dwywdo.toyspringboard.model.Post;
import com.dwywdo.toyspringboard.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post uploadPost(Post post){
        return postRepository.save(post);
    }

    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Optional<Post> getPost(long id) { return postRepository.findById(id); }

    public String deletePost(long id) {
        postRepository.deleteById(id);
        return "Post was deleted";
    }

}
