package com.mateusz113.git_hub_proj.git_hub_project.service;

import com.mateusz113.git_hub_proj.git_hub_project.client.GitHubClient;
import com.mateusz113.git_hub_proj.git_hub_project.exception.repository.RepositoryAlreadyExistsException;
import com.mateusz113.git_hub_proj.git_hub_project.exception.repository.RepositoryNotFoundException;
import com.mateusz113.git_hub_proj.git_hub_project.mapper.RepositoryMapper;
import com.mateusz113.git_hub_proj.git_hub_project.model.Repository;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryData;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import com.mateusz113.git_hub_proj.git_hub_project.repository.RepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final Clock clock;
    private final GitHubClient gitHubClient;
    private final RepositoryRepository repositoryRepository;
    private final RepositoryMapper repositoryMapper;

    public RepositoryDto getRepositoryData(String owner, String repositoryName) {
        return repositoryMapper.dataToDto(getRepositoryDataFromClient(owner, repositoryName));
    }

    public RepositoryDto getLocalRepositoryData(String owner, String repoName) {
        String fullName = getRepositoryFullName(owner, repoName);
        Repository repository = repositoryRepository.findByFullName(fullName);
        if (repository == null) {
            throw new RepositoryNotFoundException("Repository with given data was not found.", OffsetDateTime.now(clock));
        }
        return repositoryMapper.toDto(repository);
    }

    public RepositoryDto saveRepositoryData(String owner, String repoName) {
        RepositoryData data = getRepositoryDataFromClient(owner, repoName);
        Repository repository = repositoryMapper.toEntity(data);
        String fullName = getRepositoryFullName(owner, repoName);
        if (repositoryRepository.existsByFullName(fullName)) {
            throw new RepositoryAlreadyExistsException("Repository with given name and owner already exists.", OffsetDateTime.now(clock));
        }
        repository = repositoryRepository.save(repository);
        return repositoryMapper.toDto(repository);
    }

    private RepositoryData getRepositoryDataFromClient(String owner, String repoName) {
        return gitHubClient.getRepositoryData(owner, repoName);
    }

    private String getRepositoryFullName(String owner, String repoName) {
        return "%s/%s".formatted(owner, repoName);
    }
}
