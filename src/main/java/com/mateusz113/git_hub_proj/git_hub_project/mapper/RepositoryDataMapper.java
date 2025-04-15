package com.mateusz113.git_hub_proj.git_hub_project.mapper;

import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryData;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryDataMapper {
    @Mapping(target = "fullName", source = "name")
    @Mapping(target = "cloneUrl", source = "clone_url")
    @Mapping(target = "stars", source = "stargazers_count")
    @Mapping(target = "createdAt", source = "created_at")
    RepositoryDto toDto(RepositoryData repositoryData);
}
