package com.mateusz113.git_hub_proj.git_hub_project.service;

import com.mateusz113.git_hub_proj.git_hub_project.client.GitHubClient;
import com.mateusz113.git_hub_proj.git_hub_project.mapper.RepositoryDataMapper;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryData;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final GitHubClient gitHubClient;
    private final RepositoryDataMapper repositoryDataMapper;

    public RepositoryDto getRepositoryData(String owner, String repositoryName) {
        RepositoryData data = gitHubClient.getRepositoryData(owner, repositoryName);
        return repositoryDataMapper.toDto(data);
    }
}
