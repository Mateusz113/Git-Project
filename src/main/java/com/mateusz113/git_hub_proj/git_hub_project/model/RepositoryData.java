package com.mateusz113.git_hub_proj.git_hub_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record RepositoryData(
        @JsonProperty("full_name")
        String fullName,
        String description,
        @JsonProperty("clone_url")
        String cloneUrl,
        @JsonProperty("stargazers_count")
        Long stars,
        @JsonProperty("created_at")
        OffsetDateTime createdAt
) {
}
