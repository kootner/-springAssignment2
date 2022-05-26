package com.sparta.blogmaking.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter     // 정보를 가져오게 함
@NoArgsConstructor  // 기본생성자 생성
@Entity     // 테이블과 연계됨 스프링에게 알려줌
public class Blog extends Timestamped {

    @Id     // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO)  // 자동증가 명렬
    private Long id;    // Long형으로 id 변수 설정

    @Column(nullable = false)   // 컬럼 값이고 반드시 값이 존재해야함
    private String title;       // String형으로 title 변수 설정

    @Column(nullable = false)   // 컬럼 값이고 반드시 값이 존재해야함
    private String nickname;    // username title 변수 설정

    @Column(nullable = false)    // 컬럼 값이고 반드시 값이 존재해야함
    private String contents;     // String형으로 contents 변수 설정

    @Column(nullable = false)
    private String password;


    public Blog(String title, String nickname, String contents, String password) {   // 생성자 Blog에 매개변수 title, username, contents 설정
        this.title = title;             // 매개변수 title값을 private String title에 대입
        this.nickname = nickname;       // 매개변수 username값을 private String username에 대입
        this.contents = contents;       // 매개변수 contents값을 private String contents에 대입
        this.password = password;
    }

    public Blog(BlogRequestDto requestDto) {           // 생성자 BlogRequestDto에 값
        this.title = requestDto.getTitle();            // requestDto.getTitle()를 private String title에 대입
        this.nickname = requestDto.getNickname();      // requestDto.getUsername()를 private String username 대입
        this.contents = requestDto.getContents();      // requestDto.getContents()를 private String contents 대입
        this.password = requestDto.getPassword();
    }

    public void update(BlogRequestDto requestDto) {     // 서비스에서 전달받기로한 requestDto를 넣어줌
        this.title = requestDto.getTitle();             // Dto에 있는 값이 blog로 들어감
        this.nickname = requestDto.getNickname();       // Dto에 있는 값이 blog로 들어감
        this.contents = requestDto.getContents();       // Dto에 있는 값이 blog로 들어감
        this.password = requestDto.getPassword();
    }



}
