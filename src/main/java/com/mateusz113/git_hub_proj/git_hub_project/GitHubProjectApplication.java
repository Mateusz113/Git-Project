package com.mateusz113.git_hub_proj.git_hub_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GitHubProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitHubProjectApplication.class, args);
	}

}
