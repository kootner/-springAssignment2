package com.sparta.blogmaking.domain;

import lombok.Getter;


@Getter
public class BlogListDto {
    private String title;
    private String nickname;


    public BlogListDto(String title, String nickname) {
        this.title = title;
        this.nickname = nickname;
    }
}
