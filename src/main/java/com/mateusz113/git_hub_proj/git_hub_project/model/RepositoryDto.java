package com.mateusz113.git_hub_proj.git_hub_project.model;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record RepositoryDto(
        String fullName,
        String description,
        String cloneUrl,
        Long stars,
        OffsetDateTime createdAt
) {
}
