package com.sparta.blogmaking.repository;

import com.sparta.blogmaking.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {     // 이
    List<Blog> findAllByOrderByCreatedAtDesc();
}
