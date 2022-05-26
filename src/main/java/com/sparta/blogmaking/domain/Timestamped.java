package com.sparta.blogmaking.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 상속했을 때, Column으로 인식하게됨
@EntityListeners(AuditingEntityListener.class)  // 생성/수정 시간을 자동으로 반영하도록 설정
public abstract class Timestamped{      // public 클래스 생성

    @CreatedDate             // 생성일자임을 나타냄
    private LocalDateTime createdAt;    // 날짜와 시간 정보 모두가 필요할 때 사용.

    @LastModifiedDate       // 마지막 수정일자임을 나타냄
    private LocalDateTime modifiedAt;       // 날짜와 시간 정보 모두가 필요할 때 사용.
}
