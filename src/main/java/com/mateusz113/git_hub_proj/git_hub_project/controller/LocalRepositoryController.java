package com.mateusz113.git_hub_proj.git_hub_project.controller;

import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import com.mateusz113.git_hub_proj.git_hub_project.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("local/repositories/")
@RequiredArgsConstructor
public class LocalRepositoryController {
    private final RepositoryService repositoryService;

    @GetMapping("/{owner}/{repository-name}")
    public RepositoryDto getLocalRepositoryData(@PathVariable String owner, @PathVariable("repository-name") String repoName) {
        return repositoryService.getLocalRepositoryData(owner, repoName);
    }
}
