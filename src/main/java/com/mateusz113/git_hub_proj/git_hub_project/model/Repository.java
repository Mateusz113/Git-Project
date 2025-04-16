package com.mateusz113.git_hub_proj.git_hub_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity(name = "REPOSITORIES")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true)
    private String fullName;
    private String description;
    private String cloneUrl;
    private Long stars;
    private OffsetDateTime createdAt;
}
