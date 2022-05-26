package com.sparta.blogmaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogmakingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogmakingApplication.class, args);
	}

}
