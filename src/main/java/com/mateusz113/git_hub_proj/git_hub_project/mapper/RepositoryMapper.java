package com.mateusz113.git_hub_proj.git_hub_project.mapper;

import com.mateusz113.git_hub_proj.git_hub_project.model.Repository;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryData;
import com.mateusz113.git_hub_proj.git_hub_project.model.RepositoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {
    RepositoryDto toDto(Repository repository);

    @Mapping(target = "id", ignore = true)
    Repository toEntity(RepositoryData repositoryData);

    RepositoryDto dataToDto(RepositoryData repositoryData);
}
