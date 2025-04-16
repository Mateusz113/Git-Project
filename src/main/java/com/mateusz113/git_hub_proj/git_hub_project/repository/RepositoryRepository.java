package com.mateusz113.git_hub_proj.git_hub_project.repository;

import com.mateusz113.git_hub_proj.git_hub_project.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryRepository extends JpaRepository<Repository, Long> {
    Optional<Repository> findByFullName(String fullName);

    boolean existsByFullName(String fullName);
}
