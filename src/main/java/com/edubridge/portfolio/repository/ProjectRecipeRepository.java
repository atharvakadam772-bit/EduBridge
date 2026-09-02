package com.edubridge.portfolio.repository;

import com.edubridge.portfolio.model.ProjectRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRecipeRepository extends JpaRepository<ProjectRecipe, Long> {
}