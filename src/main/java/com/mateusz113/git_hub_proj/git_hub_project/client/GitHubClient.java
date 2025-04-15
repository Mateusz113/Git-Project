package com.mateusz113.git_hub_proj.git_hub_project.client;

import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github-client", url = "${spring.cloud.openfeign.client.config.github-client.url}")
public interface GitHubClient {
    @GetMapping("repos/{owner}/{repo-name}")
    RepositoryData getRepositoryData(@PathVariable String owner, @PathVariable("repo-name") String repoName);
}
