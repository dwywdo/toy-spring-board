package com.dwywdo.toyspringboard;

import org.springframework.data.repository.PagingAndSortingRepository;

// Do not define Repository Class like PostRepository<Post, Integer>
// todo. Research about this
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

}
