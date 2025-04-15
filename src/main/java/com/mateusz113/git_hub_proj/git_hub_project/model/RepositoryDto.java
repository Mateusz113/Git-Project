package com.mateusz113.git_hub_proj.git_hub_project.model;

import java.time.OffsetDateTime;

public record RepositoryDto(
        String fullName,
        String description,
        String cloneUrl,
        Long stars,
        OffsetDateTime createdAt
) {
}
