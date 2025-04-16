package com.mateusz113.git_hub_proj.git_hub_project.repository;

import com.mateusz113.git_hub_proj.git_hub_project.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRepository extends JpaRepository<Repository, Long> {
    Repository findByFullName(String fullName);

    boolean existsByFullName(String fullName);
}
