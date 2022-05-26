package com.sparta.blogmaking.controller;

import com.sparta.blogmaking.domain.*;
import com.sparta.blogmaking.domain.BlogListDto;
import com.sparta.blogmaking.repository.BlogRepository;
import com.sparta.blogmaking.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor    // final로 선언된 변수가 있으면 생성할때 같이 생성자 주입
@RestController     // @Controller + @ResponseBody
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @GetMapping("/api/blogs")            // "/api/blogs" URL이랑 createBlog가 매칭되도록 함
    public List<BlogListDto> blogList() {           // Blog이름으로 저장된 데이터를
        return blogService.blogList();
    }

    @GetMapping("/api/blogs/list")            // "/api/blogs" URL이랑 createBlog가 매칭되도록 함
    public List<BlogAllListDto> allBlogList() {           // Blog이름으로 저장된 데이터를
        return blogService.allBlogList();
    }

    @PostMapping("/api/blogslist")            // "/api/blogs" URL이랑 createBlog가 매칭되도록 함
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) { // 메개변수에 데이터를 JSON형식으로 받음
        Blog blog = new Blog(requestDto);   // blog라는 객체 내용에 requestDto 값을 넣음
        return blogRepository.save(blog);   // DB에 생성된 객체 blog라는 데이터를 저장
    }

    @GetMapping("/api/blogslist")            // "/api/blogs" URL이랑 createBlog가 매칭되도록 함
    public List<Blog> getBlog() {           // Blog이름으로 저장된 데이터를
        return blogRepository.findAllByOrderByCreatedAtDesc(); // 전부 가져옴
    }

    @DeleteMapping("/api/blogs/{id}")    // "/api/blogs/{id}" URL이랑 deleteBlog가 매칭되도록 함
    public Long deleteBlog(@PathVariable Long id,@RequestParam("password") String password) {     // URL경로 {id}에 변수 id를 넣어줌
        blogService.delete(id,password);
        return id;
    }

    @PutMapping("/api/blogs/{id}")        // "/api/blogs/{id}" URL이랑 updateBlog가 매칭되도록 함
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) { // URL경로 {id}에 변수 id를 넣어주고 메개변수에 데이터를 JSON형식으로 받음
        blogService.update(id, requestDto);     // id에 일치하는 부분에 데이터들을 변경요청받은 값으로 수정해서 DTO로 전달
        return id;
    }


}