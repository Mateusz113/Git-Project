package com.mateusz113.git_hub_proj.git_hub_project.model;

import java.time.OffsetDateTime;

public record RepositoryData(
        String name,
        String description,
        String clone_url,
        Long stargazers_count,
        OffsetDateTime created_at
) {
}
