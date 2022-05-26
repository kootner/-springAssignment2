package com.sparta.blogmaking.domain;

import lombok.Getter;

@Getter  // 정보를 가져오게 함 값설정은 request받으면 스프링이 알아서 해줌
public class BlogRequestDto {       // public 클래스
    private String title;           // 맴버변수 title 선언
    private String nickname;        // 맴버변수 username 선언
    private String contents;        // 맴버변수 contents 선언
    private String password;
}
