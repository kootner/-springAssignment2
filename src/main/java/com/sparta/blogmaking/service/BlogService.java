package com.sparta.blogmaking.service;

import com.sparta.blogmaking.domain.*;
import com.sparta.blogmaking.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor    // final로 선언된 변수가 있으면 생성할때 같이 생성자 주입
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BlogService {

    private final BlogRepository blogRepository;    // 서비스에 맴버변수로 Repository 선언함

    @Transactional
    public List<BlogListDto> blogList() {
        List<Blog> bloglist = blogRepository.findAllByOrderByCreatedAtDesc();
        List<BlogListDto> allblog = new ArrayList<>();
        for (int i = 0; i < bloglist.size(); i++) {
            Blog blog = bloglist.get(i);
            BlogListDto boardListRequestDto = new BlogListDto(blog.getTitle(), blog.getNickname());
            allblog.add(boardListRequestDto);
        }
        return allblog;
    }

    @Transactional
    public List<BlogAllListDto> allBlogList() {
        List<Blog> bloglist1 = blogRepository.findAllByOrderByCreatedAtDesc();
        List<BlogAllListDto> allblog1 = new ArrayList<>();
        for (int i = 0; i < bloglist1.size(); i++) {
            Blog blog = bloglist1.get(i);
            BlogAllListDto blogAllListDto1 = new BlogAllListDto(blog.getTitle(), blog.getNickname(), blog.getContents(),blog.getCreatedAt());
            allblog1.add(blogAllListDto1);
        }
        return allblog1;
    }

    @Transactional      // 자동으로 커밋 해줌
    public void delete(Long id, String password) {        //   id랑 정보가 필요해서 Dto로 정보를 받아옴
        Blog blog = blogRepository.findById(id).orElseThrow(        // id를 기준으로 정보를 찾고 없으면
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")    // 오류 발생을 일으킴킴
        );
        if (password.equals(blog.getPassword())){
          blogRepository.deleteById(id);
        } else{
            System.out.println("비밀번호가 다릅니다.");
        }
    }

    @Transactional      // 자동으로 커밋 해줌
    public void update(Long id, BlogRequestDto requestDto) {        //   id랑 정보가 필요해서 Dto로 정보를 받아옴
        Blog blog = blogRepository.findById(id).orElseThrow(        // id를 기준으로 정보를 찾고 없으면
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")    // 오류 발생을 일으킴킴
        );
         if (requestDto.getPassword().equals(blog.getPassword())){
            blog.update(requestDto);
        } else{
            System.out.println("비밀번호가 다릅니다.");
        }
    }
}
