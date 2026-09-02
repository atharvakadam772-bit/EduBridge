package com.edubridge.portfolio.service;

import com.edubridge.portfolio.model.JobRole;
import com.edubridge.portfolio.model.ProjectRecipe;
import com.edubridge.portfolio.model.Skill;
import com.edubridge.portfolio.repository.JobRoleRepository;
import com.edubridge.portfolio.repository.ProjectRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GapAnalysisService {

    private final JobRoleRepository jobRoleRepository;
    private final ProjectRecipeRepository recipeRepository;

    public GapAnalysisService(JobRoleRepository jobRoleRepository, ProjectRecipeRepository recipeRepository) {
        this.jobRoleRepository = jobRoleRepository;
        this.recipeRepository = recipeRepository;
    }

    public Map<String, Object> performAnalysis(Long roleId, Set<String> curriculumSkillNames) {
        JobRole targetRole = jobRoleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<String> requiredSkillNames = targetRole.getRequiredSkills().stream()
                .map(Skill::getName)
                .collect(Collectors.toSet());

        // Differential Analysis
        Set<String> missingSkills = new HashSet<>(requiredSkillNames);
        missingSkills.removeAll(curriculumSkillNames);

        Set<String> coveredSkills = new HashSet<>(requiredSkillNames);
        coveredSkills.retainAll(curriculumSkillNames);

        // Calculate Match Score Percentage
        int totalRequired = requiredSkillNames.size();
        int matchPercentage = totalRequired > 0 ? (int) Math.round(((double) coveredSkills.size() / totalRequired) * 100) : 0;

        // Smart Recipe Matching Algorithm
        List<ProjectRecipe> allRecipes = recipeRepository.findAll();
        ProjectRecipe bestMatch = null;
        long maxCoverage = -1;

        for (ProjectRecipe recipe : allRecipes) {
            Set<String> recipeSkillNames = recipe.getCoveredSkills().stream()
                    .map(Skill::getName)
                    .collect(Collectors.toSet());

            long coverageCount = recipeSkillNames.stream().filter(missingSkills::contains).count();
            if (coverageCount > maxCoverage) {
                maxCoverage = coverageCount;
                bestMatch = recipe;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("roleTitle", targetRole.getTitle());
        result.put("requiredSkills", requiredSkillNames);
        result.put("coveredSkills", coveredSkills);
        result.put("missingSkills", missingSkills);
        result.put("matchPercentage", matchPercentage);
        result.put("recommendedRecipe", bestMatch);
        return result;
    }
}