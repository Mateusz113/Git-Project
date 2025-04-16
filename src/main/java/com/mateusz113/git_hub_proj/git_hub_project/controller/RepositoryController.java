package com.mateusz113.git_hub_proj.git_hub_project.controller;

import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import com.mateusz113.git_hub_proj.git_hub_project.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repositories")
public class RepositoryController {
    private final RepositoryService repositoryService;

    @GetMapping("/{owner}/{repository-name}")
    public RepositoryDto getRepositoryData(@PathVariable String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryService.getRepositoryData(owner, repositoryName);
    }

    @PostMapping("/{owner}/{repository-name}")
    @ResponseStatus(HttpStatus.CREATED)
    public RepositoryDto saveRepositoryData(@PathVariable String owner, @PathVariable("repository-name") String repoName) {
        return repositoryService.saveRepositoryData(owner, repoName);
    }
}
