package com.sparta.blogmaking.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Getter
public class BlogAllListDto {

    private String title;
    private String nickname;
    private String contents;
    @CreatedDate
    private LocalDateTime createdAt;


    public BlogAllListDto(String title, String nickname, String contents, LocalDateTime createAt) {
        this.title = title;
        this.nickname = nickname;
        this.contents = contents;
        this.createdAt = createAt;

    }
}
